/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 13:38:36 GMT 2019
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
      String string0 = WordUtils.wrap("5.1", (-2887), "zqhPJ7kH*_xI", true);
      assertEquals("5zqhPJ7kH*_xI.zqhPJ7kH*_xI1", string0); // (Primitive) Original Value: 5zqhPJ7kH*_xI.zqhPJ7kH*_xI1 | Regression Value: 5zqhPJ7kH*_xI1
  }
}
