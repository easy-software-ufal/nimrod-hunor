/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 14:18:01 GMT 2019
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
      String string0 = "]G@}kiM)sP \"?Wq0;5";
      String string1 = WordUtils.wrap("]G@}kiM)sP \"?Wq0;5", (-3199), "", false);
      assertEquals("]G@}kiM)sP\"?Wq0;5", string1); // (Primitive) Original Value: ]G@}kiM)sP"?Wq0;5 | Regression Value: ]G@}kiM)sP "?Wq0;5
      assertFalse(string1.equals((Object)string0));
  }
}
