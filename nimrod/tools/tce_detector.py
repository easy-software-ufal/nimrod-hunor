import os
import re
import time

from nimrod.tools.tce.src import main
from nimrod.tools.bin import SOOT, RT_JAR

TIMEOUT = 40

# JUnitResult = namedtuple('JUnitResult', ['ok_tests', 'fail_tests', 
#                                          'fail_test_set', 'run_time',
#                                          'coverage', 'timeout'])


class Tce:

    def __init__(self, exp_dir, mujava_res):
        self.mujava_res = mujava_res
        self.exp_dir = exp_dir
        self.equiv_mutants = []
        self.dupl_mutants = []
        
    def exec(self, action, timeout=TIMEOUT):        
        # 'method(s) to be considered; if not provided, consider all methods. Note that the names of the methods are the ones returned by mujava'
        methods = ''
        # 'the maximum number of mutants to optimise; if not provided, optimise them all'
        mutants = ''

        return self._exec(str(RT_JAR), str(SOOT), self.mujava_res, self.exp_dir, action, methods, mutants)
    

    def _exec(self, rt_jar, soot, mujava_res, exp_dir, action, methods, mutants):

        # params = (
        #     '-javaagent:'+str(JMOCKIT), 
        #     '-classpath', classpath,
        #     '-Dcoverage-classes=' + sut_class,
        #     '-Dcoverage-output=html',
        #     '-Dcoverage-metrics=line',
        #     '-Dcoverage-srcDirs=' + cov_src_dirs,
        #     'org.junit.runner.JUnitCore', test_class
        # )

        start = time.time()
        try:            
            output = main.exec(rt_jar, soot, mujava_res, exp_dir, action, methods, mutants)
            return Tce._extract_results_succ(action, output)
            
        except Exception as e:
            print("### ERROR #####")
            print(e)
            # return JUnitResult(
            #     *Tce._extract_results(e.output.decode('unicode_escape')),
            #     time.time() - start, None, False
            # )
        

    @staticmethod
    def _extract_results_succ(action, output):
        if(action == 'Opt'):
            return ''
        elif(action == 'Ted'):
            equivalents = []
            if(output is not None):
                classes = output.keys()
                for classe in classes:
                    methods = output[classe]
                    for method in methods.keys():
                        mutants = methods[method]
                        equivalents.extend(mutants)
            return equivalents
        elif(action == "Ted-dupes"):
            duplicates = []
            if(output is not None):
                classes = output.keys()
                for classe in classes:
                    methods = output[classe]
                    for method in methods.keys():
                        mutants = methods[method]
                        flat_list = [item for sublist in mutants.values() for item in sublist]
                        duplicates.extend(flat_list)
            return duplicates
        else:
            raise Exception("No valid action selected to execute TCE") 

    @staticmethod
    def _extract_results_fail(output):
        pass
        # if len(re.findall(r'initializationError', output)) == 0:
        #     result = re.findall(r'Tests run: [0-9]*,[ ]{2}Failures: [0-9]*',
        #                         output)
        #     if len(result) > 0:
        #         result = result[0].replace(',', ' ')
        #         r = [int(s) for s in result.split() if s.isdigit()]
        #         return r[0], r[1], JUnit._extract_test_id(output)

        # return 0, 0, set()
    
    def optimize(self):
        action = "Opt"
        results = self.exec(action)
        return results
    
    def equivalents(self):                
        action = "Ted"
        results = self.exec(action)       
        return results

    def duplicates(self):
        action = "Ted-dupes"
        results = self.exec(action)       
        return results

