/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 14:10:46 GMT 2019
 */

package org.apache.commons.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.lang.WordUtils;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class WordUtils_ESTest extends WordUtils_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      String string0 = WordUtils.wrap("org.apache.commons.lang.WordUtils", 2, (String) null, true);
      assertEquals("or\ng.\nap\nac\nhe\n.c\nom\nmo\nns\n.l\nan\ng.\nWo\nrd\nUt\nil\ns", string0); // (Primitive) Original Value: or g. ap ac he .c om mo ns .l an g. Wo rd Ut il s | Regression Value: ls
  }
}
