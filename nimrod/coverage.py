from collections import namedtuple


CoverageResults = namedtuple('CoverageResults', [
    'id',     
    'class',    
    'method',    
    'line_number',        
]) 


class Coverage:

    def __init__(self):

        self.id = 0
        self.file = ''
        self.class = ''
        self.method = ''
        self.line_num = 0
        self.stmt_id = ''
        self.stmt_desc = ''
        self.stmt_execs = ''
        self.test_methods_touch = []
                
        # self.java_home = java_home
        # self._javac = None
        # self._java = None
        # self._set_home()
        # self._check()