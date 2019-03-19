/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 12:56:35 GMT 2019
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
      String string0 = WordUtils.wrap("Cannot pad a negative amount: ", 5, "1YrY:4erQ{[", false);
      assertEquals("Cannot1YrY:4erQ{[pad a1YrY:4erQ{[negative1YrY:4erQ{[amount:1YrY:4erQ{[", string0); // (Primitive) Original Value: Cannot1YrY:4erQ{[pad a1YrY:4erQ{[negative1YrY:4erQ{[amount:1YrY:4erQ{[ | Regression Value: Cannot1YrY:4erQ{[pad a1YrY:4erQ{[negative amount: 
  }
}
