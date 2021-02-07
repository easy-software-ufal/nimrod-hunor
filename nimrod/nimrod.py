import os
import shutil
import time
import threading
import tempfile

from nimrod.tools.randoop import Randoop
from nimrod.tools.mujava import MuJava
from nimrod.tools.major import Major
from nimrod.mutant import Mutant
from nimrod.tools.safira import Safira
from nimrod.tools.tce_detector import Tce
from nimrod.tools.junit import JUnit, JUnitResult, Coverage
from nimrod.tools.evosuite import Evosuite
from nimrod.utils import package_to_dir, copy_dir

from collections import namedtuple


OUTPUT_DIR = 'nimrod_output'


NimrodResult = namedtuple('NimrodResult', ['maybe_equivalent', 'not_equivalent',
                                           'coverage', 'differential',
                                           'timeout', 'test_tool', 'is_equal_coverage'])


class Nimrod:

    def __init__(self, java, maven):
        self.java = java
        self.maven = maven        
        self.suite_evosuite_diff = None
        self.suite_evosuite = None
        self.suite_randoop = None
        #New fields
        self.tce = None
        self.testsuite_combined = None
        self.testsuite_killer = None
        self.mutants_surviving = None


    def _try_tce(self, project_dir, classes_dir, mutants_dir, sut_class):
        try:      
            #Create a temp directory to execute TCE   
            tce_temp_dir = tempfile.TemporaryDirectory()            
            self.tce = Tce(self.java, tce_temp_dir.name + "/ted", tce_temp_dir.name + "/result")                  
            self.tce.setup_tce_structure(project_dir, mutants_dir, tce_temp_dir.name, sut_class)            
            self.tce.optimize()
            #Save TCE equivalents and duplicates
            eqvs = self.tce.equivalents()
            dups = self.tce.duplicates()
            #Delete the temp directory
            tce_temp_dir.cleanup()
            return (eqvs, dups)
        except Exception as e:
            print("**ERROR: TCE NOT EXECUTED - REASON: " + str(e))


    def _del_mutants(self, mutants_dir, mutants):
        for mutant in mutants:
            print(mutants_dir + "/" + mutant)

    def _gen_automatic_tests(self, classes_dir, mutants_dir, nimrod_output_dir, sut_class, randoop_params, evosuite_params):        
        #Set up the test suite dir for the mutant...
        auto_generated_tests_dir = os.path.join(nimrod_output_dir, 'suites')

        thread_evosuite = threading.Thread(target=self._gen_evosuite, args=(classes_dir, evosuite_params, sut_class, auto_generated_tests_dir))
        thread_randoop = threading.Thread(target=self._gen_randoop, args=(classes_dir, randoop_params, sut_class, auto_generated_tests_dir))

        print('Generating automatic tests...')
        thread_evosuite.start()
        thread_randoop.start()

        # Wait the generation of the Suite in the thread
        thread_evosuite.join()
        # Wait the generation of the Suite in the thread
        thread_randoop.join()
        
        return auto_generated_tests_dir
    

    def _gen_evosuite(self, classes_dir, evosuite_params, sut_class, tests_src):
        evosuite = Evosuite(
            java=self.java,
            classpath=classes_dir,
            tests_src=tests_src,
            sut_class=sut_class,
            params=evosuite_params
        )        
        self.suite_evosuite = evosuite.generate()
        return self.suite_evosuite

    def _gen_randoop(self, classes_dir, randoop_params, sut_class, tests_src):
        randoop = Randoop(
            java=self.java,
            classpath=classes_dir,
            tests_src=tests_src,
            sut_class=sut_class,
            params=randoop_params
        )   
        self.suite_randoop = randoop.generate()             
        # if "Bisect" in sut_class:
        #     self.suite_randoop = randoop.generate()
        # else:
        #     self.suite_randoop = randoop.generate_with_impact_analysis(safira)
        #     if "Simulator" in sut_class:
        #         import distutils.dir_util
        #         distutils.dir_util.copy_tree("./config/", randoop.suite_dir + "/config/")
        return self.suite_randoop

    def _combine_tests(self, orig_test_classes_dir, auto_generated_tests_dir):
        copy_dir(auto_generated_tests_dir+'/evosuite_1/classes/', orig_test_classes_dir)
        copy_dir(auto_generated_tests_dir+'/randoop_1/classes/', orig_test_classes_dir)


    # #####  EXPERIMENT ALGORITHM #####
    #
    # 1. Execute the dev tests (through mvn) - IMPORTANT: Skip this line and take the survived mutants (in case of Defects4J)
    # **** Save the survived mutants
    # 2. Take the survived mutants and execute TCE
    # **** Remove TCE equivalents (log results)
    # **** Remove TCE duplicates (log results)
    # 3. Generate automatic tests with EvoSuite and Randoop (based on original)
    # **** Save the automatic tests alongside the dev tests (combined test set)
    # 4. Execute the combined test set to check if they are passing on original (eliminate in case of flaky)
    # 5. Take the survived mutants (minus TCE eqv and dup) and execute the combined test set
    #    For each mutant:
    #    IF mutant killed: 
    #       save the killer test, and GO TO ...
    #    ELSE mutant not killed: 
    #       save the coverage on mutant
    #       execute EvoSuiteR with the mutant
    #       IF EvoSuiteR find a test and kill the mutant:
    #           Save the killer test
    #           Add up this new test case to the combined test set
    #           Label the mutant as Non-equivalent
    #           Remove from survived set
    # 
    # 7. Take the survived mutant set  and the orignal, execute the combined test set
    # **** Save the coverage (check if any other mutant kill)
    # **** Compare coverage (and other information)
    # 8. Rank the survived mutants according to coverage information
    # ===============================================
    # OUTCOME
    # **** a) Set of equivalent mutants from TCE
    # **** b) Set of duplicate mutants from TCE
    # **** c) Set of non-equivalent mutants and the corresponding killer test-set
    # **** d) A rank of last survived mutants to manual analysis
    def run(self, orig_project_dir, mutants_dir, sut_class, randoop_params=None,
            evosuite_diff_params=None, evosuite_params=None, nimrod_output_dir=None):     

        # Compile Project With Maven       
        _, orig_classes_dir = self.maven.compile(orig_project_dir, clean=True)
        # Compile Tests with Maven
        _, orig_test_classes_dir = self.maven.test_compile(orig_project_dir)
        # get outcome results
        nimrod_output_dir = self.check_output_dir(nimrod_output_dir if nimrod_output_dir
                                           else os.path.join(orig_project_dir,
                                                             OUTPUT_DIR))        

        # 1. Execute the dev tests (through Maven) - IMPORTANT: Skip this line and take the survived mutants (in case of Defects4J)
        # **** Save the survived mutants

        # 2. Take the survived mutants and execute TCE
        # tce_eqvs, tce_dups = self._try_tce(orig_project_dir, orig_classes_dir, mutants_dir, sut_class)
        # **** Remove TCE equivalents and duplicates (TODO: need log results before)        
        # self._del_mutants(mutants_dir, set(tce_eqvs+tce_dups))
        # 3. Generate automatic tests with EvoSuite and Randoop (based on original)
        auto_generated_tests_dir = self._gen_automatic_tests(orig_classes_dir, mutants_dir, nimrod_output_dir, sut_class, randoop_params, evosuite_params)
        # **** Save the automatic tests alongside the dev tests (combined test set)
        self._combine_tests(orig_test_classes_dir, auto_generated_tests_dir)
        # 4. Execute the combined test set to check if they are passing on original (eliminate in case of flaky)
        num_tests, num_failures, num_errors, num_skipped, failed_tests = self.maven.test(orig_project_dir)
        #TODO Stop execution in case of flaky tests
        # 5. Take the survived mutants (minus TCE eqv and dup) and execute the combined test set
            #    For each mutant:
                #    IF mutant killed: 
                #       save the killer test, and GO TO ...
                #    ELSE mutant not killed: 
                #       save the coverage on mutant
                #       execute EvoSuiteR with the mutant
                #       IF EvoSuiteR find a test and kill the mutant:
                #           Save the killer test
                #           Add up this new test case to the combined test set
                #           Label the mutant as Non-equivalent
                #           Remove from survived set
        # ****
        #Configure mutant tool, compile mutants dir, and return the mutants set
        mutants = self.get_mutants(orig_classes_dir, mutants_dir) 
        print("Total mutants: {0}".format(len(mutants)))
        for mutant in mutants:
            print(mutant)
        







        results = {}

        _, orig_classes_dir = self.maven.compile(orig_project_dir, clean=True)        
        nimrod_output_dir = self.check_output_dir(nimrod_output_dir if nimrod_output_dir
                                           else os.path.join(orig_project_dir,
                                                             OUTPUT_DIR))

        #Configure mutant tool, compile mutants dir, and return the mutants set
        mutants = self.get_mutants(orig_classes_dir, mutants_dir) 
        print("Total mutants: {0}".format(len(mutants)))
        for mutant in mutants:
            start_time = time.time()
            if self.check_mutant(mutant, sut_class): #Check if mutant (and dir) exists...
                #Set the test suite dir for the mutant...
                tests_src = os.path.join(nimrod_output_dir, 'suites', mutant.mid) 
                #Start Threads to generate the test suites
                thread_evosuite_diff, thread_evosuite, thread_randoop = self.setup_test_generation_thread(sut_class, randoop_params, evosuite_diff_params, evosuite_params, orig_classes_dir, mutant, tests_src)
                
                #Start the first thread
                thread_evosuite_diff.start()
                # Wait the generation of the Suite in the thread
                thread_evosuite_diff.join()
                #Start to execute the test suites...
                test_result = self.try_evosuite_diff(orig_classes_dir, tests_src,
                                                     sut_class, mutant,
                                                     evosuite_diff_params)                
                
                if test_result.fail_tests > 0 or test_result.timeout: #If killed by EvoSuiteR Diff
                    results[mutant.mid] = self.create_nimrod_result(test_result,
                                                                    True, 'evosuite')
                else:
                    thread_evosuite.start()
                    thread_randoop.start()
                    # Wait the generation of the Suite in the thread
                    thread_evosuite.join()
                    # EvoSuite tests generated, time to execute with original to check all tests pass
                    evo_test_result_original = self.try_evosuite(orig_classes_dir, tests_src,
                                                        sut_class, original,
                                                        evosuite_params)

                    evo_test_result = self.try_evosuite(orig_classes_dir, tests_src,
                                                        sut_class, mutant,
                                                        evosuite_params)
                    if evo_test_result and (evo_test_result.fail_tests > 0
                                            or evo_test_result.timeout): #Se Killed pelo EvoSuite
                        results[mutant.mid] = self.create_nimrod_result(
                            evo_test_result, False, 'evosuite')
                    else:
                        # Wait the generation of the Suite in the thread
                        thread_randoop.join()
                        ran_test_result = self.try_randoop(
                            orig_classes_dir, tests_src, sut_class, mutant,
                            randoop_params)
                        if ran_test_result and (ran_test_result.fail_tests > 0
                                                or ran_test_result.timeout): #Se killed pelo Randoop
                            results[mutant.mid] = self.create_nimrod_result(
                                ran_test_result, False, 'randoop')
                        else:
                            # If no test kill, check coverage with original
                            is_equal_coverage = self.check_class_coverage(orig_classes_dir,
                                                        sut_class, mutant, evo_test_result, ran_test_result)
                            results[mutant.mid] = self.sum_nimrod_result(
                                ran_test_result, evo_test_result, False, is_equal_coverage=is_equal_coverage)

                self.print_result(mutant, results[mutant.mid])
                exec_time = time.time() - start_time
                self.write_to_csv(results[mutant.mid], mutant, nimrod_output_dir, exec_time=exec_time)
                if thread_evosuite_diff.is_alive():
                    thread_evosuite_diff.join()
                if thread_evosuite.is_alive():
                    thread_evosuite.join()
                if thread_randoop.is_alive():
                    thread_randoop.join()

        return results

    def setup_test_generation_thread(self, sut_class, randoop_params, evosuite_diff_params, evosuite_params, classes_dir, mutant, tests_src):
        thread_evosuite_diff = threading.Thread(target=self.gen_evosuite_diff, args=(classes_dir, evosuite_diff_params, mutant, sut_class, tests_src))
        thread_evosuite = threading.Thread(target=self.gen_evosuite, args=(classes_dir, evosuite_params, mutant, sut_class, tests_src))
        thread_randoop = threading.Thread(target=self.gen_randoop, args=(classes_dir, mutant, randoop_params, sut_class, tests_src))
        return thread_evosuite_diff,thread_evosuite,thread_randoop

    @staticmethod
    def print_result( mutant, result):
        if result.maybe_equivalent:
            print('{0} may be equivalent. Coverage: {1}. Executions: {2}.'
                  .format(mutant.mid, 'Equal' if(result.is_equal_coverage) else 'Different', result.coverage.executions))
        else:
            print('{0} is not equivalent. {1}'
                  .format(mutant.mid, 'Killed by differential test.' if
                          result.differential else ''))

    #Check if mutant (and directory) exists...
    @staticmethod
    def check_mutant(mutant, sut_class):
        print("Analyzing mutant: {0}".format(mutant.mid))
        if os.path.exists(mutant.dir):
            class_file = os.path.join(mutant.dir, package_to_dir(sut_class) +
                                      '.class')
            if not os.path.exists(class_file):
                print("{0}: .class not found.".format(mutant.mid))
                return False
            else:
                return True
        else:
            print('{0}: directory not found.'.format(mutant.mid))
            return False
    
    #Configure mutant tool, compile mutants dir, and return the mutants set
    def get_mutants(self, classpath, mutants_dir):        
        if('mujava' in mutants_dir):
            mujava = MuJava(self.java, mutants_dir)
            mutants = mujava.read_log()
            mujava.compile_mutants(classpath, mutants)
            return mutants
        elif('major' in mutants_dir):
            major = Major(self.java, mutants_dir)
            mutants = major.read_log()
            major.compile_mutants(classpath, mutants)
            return mutants
        return []    

    def get_coverage_bool(self, orig_result,  mutant_result):        
        info_coverage = False
        if orig_result == None and mutant_result == None:
            return True #não conseguiu montar coverage nem no original , nem no mutante, entao igual
        elif orig_result == None or mutant_result == None:
            return False #Se apenas um for None e o outro nao for None, entao sao diferentes coverages
        elif orig_result.coverage.class_coverage == mutant_result.coverage.class_coverage:
            return True #Se a copia do Coverage for exatamente igual
        else: #Existem casos especiais que precisam ser analisados linha a linha (ex. qnd ocorre uma delecao de stmt)
            for k,v in orig_result.coverage.class_coverage.items():
                dict_orig = dict(v)
                dict_mut = dict(mutant_result.coverage.class_coverage[k])
                for k_orig,v_orig in dict_orig.items():
                    if(k_orig in dict_mut.keys()):#Se a linha existir no mutante...
                        if(dict_orig[k_orig] != dict_mut[k_orig]): #uma linha teve resultado diferente
                            return False
                    else: #Se a linha nao exitir no mutante, verificamos se ela teve alguma cobrtura no original
                        if(dict_orig[k_orig] > 0):
                            return False
                                
        return True #nao consegui provar diferença, entao entendo q seja igual o Coverage

    def check_class_coverage(self, classes_dir, sut_class, mutant, evo_test_result, ran_test_result):

        evosuite_coverage = False
        randoop_coverage = False        

        original_dir = os.path.join(
                            mutant.dir[:mutant.dir.rfind(os.sep)], 'ORIGINAL')
        original = Mutant(mid='ORIGINAL', operator=None, line_number=None,
                      method=None, transformation=None, dir=original_dir)

        junit = JUnit(java=self.java, classpath=classes_dir)
        orig_evosuite_result = (junit.run_with_mutant(self.suite_evosuite, sut_class, original)
                if self.suite_evosuite else None)        
        orig_ran_result = (junit.run_with_mutant(self.suite_randoop, sut_class, original)
                if self.suite_randoop else None)        

        evosuite_coverage = self.get_coverage_bool(orig_evosuite_result, evo_test_result)
        randoop_coverage = self.get_coverage_bool(orig_ran_result, ran_test_result)

        try:
            print(sut_class)
            print('--', orig_ran_result.coverage.class_coverage)
            print('--', ran_test_result.coverage.class_coverage)
            print('++', orig_evosuite_result.coverage.class_coverage)
            print('++', evo_test_result.coverage.class_coverage)        
        except:
            print('-- No Log')

        return  (evosuite_coverage and randoop_coverage)

    

    def try_evosuite_diff(self, classes_dir, tests_src, sut_class, mutant,
                     evosuite_diff_params=None):
        junit = JUnit(java=self.java, classpath=classes_dir)
        return junit.run_with_mutant(self.suite_evosuite_diff, sut_class, mutant)


    def try_evosuite(self, classes_dir, tests_src, sut_class, mutant=None,
                     evosuite_params=None):
        junit = JUnit(java=self.java, classpath=classes_dir)
        if mutant is None:
            return (junit.run_with_original(self.suite_evosuite, sut_class, classes_dir)
                if self.suite_evosuite else None)
        else:
            return (junit.run_with_mutant(self.suite_evosuite, sut_class, mutant)
                if self.suite_evosuite else None)


    def try_randoop(self, classes_dir, tests_src, sut_class, mutant,
                    randoop_params=None):
        junit = JUnit(java=self.java, classpath=classes_dir)
        return (junit.run_with_mutant(self.suite_randoop, sut_class, mutant)
                if self.suite_randoop else None)

    def gen_evosuite_diff(self, classes_dir, evosuite_diff_params, mutant, sut_class, tests_src):
        evosuite = Evosuite(
            java=self.java,
            classpath=classes_dir,
            tests_src=tests_src,
            sut_class=sut_class,
            params=evosuite_diff_params
        )
        self.suite_evosuite_diff = evosuite.generate_differential(mutant.dir)
        return self.suite_evosuite_diff

    def gen_evosuite(self, classes_dir, evosuite_params, mutant, sut_class, tests_src):
        evosuite = Evosuite(
            java=self.java,
            classpath=classes_dir,
            tests_src=tests_src,
            sut_class=sut_class,
            params=evosuite_params
        )
        # suite = evosuite.generate()
        safira = Safira(java=self.java, classes_dir=classes_dir,
                        mutant_dir=mutant.dir)
        self.suite_evosuite = evosuite.generate_with_impact_analysis(safira)
        if "Simulator" in sut_class:
            import distutils.dir_util
            distutils.dir_util.copy_tree("./config/", evosuite.suite_dir + "/config/")

        return self.suite_evosuite

    def gen_randoop(self, classes_dir, mutant, randoop_params, sut_class, tests_src):
        randoop = Randoop(
            java=self.java,
            classpath=classes_dir,
            tests_src=tests_src,
            sut_class=sut_class,
            params=randoop_params
        )
        safira = Safira(java=self.java, classes_dir=classes_dir,
                        mutant_dir=mutant.dir)
        if "Bisect" in sut_class:
            self.suite_randoop = randoop.generate()
        else:
            self.suite_randoop = randoop.generate_with_impact_analysis(safira)
            if "Simulator" in sut_class:
                import distutils.dir_util
                distutils.dir_util.copy_tree("./config/", randoop.suite_dir + "/config/")
        return self.suite_randoop

    @staticmethod
    def check_output_dir(output_dir):
        output_dir = os.path.abspath(os.path.join('.', output_dir))
        if os.path.exists(output_dir):
            shutil.rmtree(output_dir)
        os.makedirs(output_dir)

        return output_dir

    @staticmethod
    def create_nimrod_result(test_result, differential, test_tool, is_equal_coverage=False):
        return NimrodResult(
            test_result.fail_tests == 0 and not test_result.timeout,
            test_result.fail_tests > 0 or test_result.timeout,
            test_result.coverage, differential, test_result.timeout, test_tool, is_equal_coverage)

    @staticmethod
    def sum_nimrod_result(ran, evo, differential, is_equal_coverage):
        if ran and evo:
            return Nimrod.create_nimrod_result(
                JUnitResult(
                    ok_tests=ran.ok_tests + evo.ok_tests,
                    fail_tests=ran.fail_tests + evo.fail_tests,
                    fail_test_set=ran.fail_test_set.union(evo.fail_test_set),
                    run_time=ran.run_time + evo.run_time,
                    coverage=Coverage(
                        call_points=(ran.coverage.call_points
                                     .union(evo.coverage.call_points)),
                        test_cases=(ran.coverage.test_cases
                                    .union(evo.coverage.test_cases)),
                        executions=(ran.coverage.executions
                                    + evo.coverage.executions),
                        class_coverage=dict(evo.coverage.class_coverage, **ran.coverage.class_coverage),          
                    ),
                    timeout=ran.timeout or evo.timeout
                ),
                differential, 
                '',
                is_equal_coverage
            )
        elif ran:
            return Nimrod.create_nimrod_result(ran, differential, '', is_equal_coverage)
        elif evo:
            return Nimrod.create_nimrod_result(evo, differential, '', is_equal_coverage)

    @staticmethod
    def write_to_csv(result, mutant, output_dir='.', filename='nimrod.csv',
                     exclude_if_exists=False, exec_time=0):
        file = os.path.join(output_dir, filename)

        if exclude_if_exists:
            if os.path.exists(file):
                os.remove(file)

        if not os.path.exists(file):
            with open(file, 'w') as f:
                f.write('mutant,maybe_equivalent,not_equivalent,differential,' +
                        'timeout,killed_by,test_case,exec_time,call_points,test_cases,executions,equal_line_coverage\n')

        if result and mutant:
            killer_tests = []
            if(len(result.coverage.test_cases)>0):
                killer_tests = [t[0]+'#'+t[1] for t in result.coverage.test_cases if len(t)==2]

            with open(file, 'a') as f:
                f.write('{0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10},{11}\n'.format(
                    mutant.mid,
                    'x' if result.maybe_equivalent else '',
                    'x' if result.not_equivalent else '',
                    'x' if result.differential else '',
                    'x' if result.timeout else '',
                    result.test_tool,
                    '' if result.maybe_equivalent else str(killer_tests).replace(',', '|'), 
                    round(exec_time, 2),                    
                    len(result.coverage.call_points),
                    len(result.coverage.test_cases),
                    result.coverage.executions,
                    result.is_equal_coverage,
                ))
                f.close()



