import os
import re
import sys
import subprocess

from collections import namedtuple


TIMEOUT = 10 * 60


MavenResults = namedtuple('MavenResults', ['source_files', 'classes_dir'])


class Maven:

    def __init__(self, java, maven_home=None, skip_compile=False):
        self.maven_home = maven_home
        self.java = java
        self.skip_compile = skip_compile

        self._set_home()
        self._check()

    def _check(self):
        try:
            self._version()
        except FileNotFoundError:
            raise SystemExit()

    def _set_home(self):
        if not self.maven_home:
            if 'M2_HOME' in os.environ and os.environ['M2_HOME']:
                self.maven_home = os.environ['M2_HOME']
            elif 'MAVEN_HOME' in os.environ and os.environ['MAVEN_HOME']:
                self.maven_home = os.environ['MAVEN_HOME']
            elif 'MVN_HOME' in os.environ and os.environ['MVN_HOME']:
                self.maven_home = os.environ['MVN_HOME']
            else:
                print("MAVEN_HOME undefined.", file=sys.stderr)
                raise SystemExit()

    def _version(self):
        return self.simple_exec('-version')

    def simple_exec(self, *args):
        return self._exec_mvn(None, self.java.get_env(), TIMEOUT, *args)

    def exec(self, timeout, *args):
        return self._exec_mvn(None, self.java.get_env(), timeout, *args)

    def _exec_mvn(self, cwd, env, timeout, *args):
        try:
            command = [os.path.join(self.maven_home,
                                    os.sep.join(['bin', 'mvn']))]
            command = command + list(args)

            return subprocess.check_output(command, cwd=cwd, env=env,
                                           timeout=timeout,
                                           stderr=subprocess.STDOUT)
        except subprocess.CalledProcessError as e:
            print('MAVEN: call process error with arguments {0}.'.format(args),
                  file=sys.stderr)
            raise e
        except subprocess.TimeoutExpired as e:
            print('MAVEN: timeout with arguments {0}.'.format(args),
                  file=sys.stderr)
            raise e
        except FileNotFoundError as e:
            print('MAVEN: not found.', file=sys.stderr)
            raise e

    def clean(self, project_dir, timeout):
        return self._exec_mvn(project_dir, self.java.get_env(), timeout,
                              'clean').decode('unicode_escape')

    def compile(self, project_dir, timeout=TIMEOUT, clean=False):
        if clean:
            print("Cleaning up project with maven...")
            self.clean(project_dir, TIMEOUT)

        print("Compiling the project with maven...")
        return self.extract_results(
            self._exec_mvn(project_dir, self.java.get_env(), timeout,
                           'compile').decode('unicode_escape')
        )

    def test_compile(self, project_dir, timeout=TIMEOUT, clean=False):
        if clean:
            print("Cleaning up project with maven...")
            self.clean(project_dir, TIMEOUT)

        print("Compiling the test project with maven...")
        extraction_result = self.extract_results(
            self._exec_mvn(project_dir, self.java.get_env(), timeout,
                           'test-compile').decode('unicode_escape'))
        if extraction_result is None: #means there is no test directory
            return MavenResults(None, None)
        else:
            return extraction_result    


    @staticmethod
    def extract_results(output):
        output = re.findall('Compiling [0-9]* source files? to .*\n', output)
        if output:
            output = output[0].replace('\n', '').split()
            return MavenResults(int(output[1]), output[-1])
        return None
