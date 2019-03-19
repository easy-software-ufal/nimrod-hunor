/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 12:51:39 GMT 2019
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
      String string0 = WordUtils.wrap(" b<dG{& ", (-1014), "", true);
      assertEquals("b<dG{&", string0); // (Primitive) Original Value: b<dG{& | Regression Value: b<dG{& 
  }
}
