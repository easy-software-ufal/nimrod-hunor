/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 13:16:45 GMT 2019
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
      String string0 = WordUtils.wrap("Search and replace array lengths don't match: ", 3, "org.apache.commons.lang.WordUtils", true);
      assertEquals("Seaorg.apache.commons.lang.WordUtilsrchorg.apache.commons.lang.WordUtilsandorg.apache.commons.lang.WordUtilsreporg.apache.commons.lang.WordUtilslacorg.apache.commons.lang.WordUtilseorg.apache.commons.lang.WordUtilsarrorg.apache.commons.lang.WordUtilsayorg.apache.commons.lang.WordUtilslenorg.apache.commons.lang.WordUtilsgthorg.apache.commons.lang.WordUtilssorg.apache.commons.lang.WordUtilsdonorg.apache.commons.lang.WordUtils'torg.apache.commons.lang.WordUtilsmatorg.apache.commons.lang.WordUtilsch:org.apache.commons.lang.WordUtils", string0); // (Primitive) Original Value: Seaorg.apache.commons.lang.WordUtilsrchorg.apache.commons.lang.WordUtilsandorg.apache.commons.lang.WordUtilsreporg.apache.commons.lang.WordUtilslacorg.apache.commons.lang.WordUtilseorg.apache.commons.lang.WordUtilsarrorg.apache.commons.lang.WordUtilsayorg.apache.commons.lang.WordUtilslenorg.apache.commons.lang.WordUtilsgthorg.apache.commons.lang.WordUtilssorg.apache.commons.lang.WordUtilsdonorg.apache.commons.lang.WordUtils'torg.apache.commons.lang.WordUtilsmatorg.apache.commons.lang.WordUtilsch:org.apache.commons.lang.WordUtils | Regression Value: Seaorg.apache.commons.lang.WordUtilsrcorg.apache.commons.lang.WordUtilsanorg.apache.commons.lang.WordUtilsreporg.apache.commons.lang.WordUtilslacorg.apache.commons.lang.WordUtilsorg.apache.commons.lang.WordUtilsarrorg.apache.commons.lang.WordUtilsaorg.apache.commons.lang.WordUtilslenorg.apache.commons.lang.WordUtilsgthorg.apache.commons.lang.WordUtilsorg.apache.commons.lang.WordUtilsdonorg.apache.commons.lang.WordUtils'org.apache.commons.lang.WordUtilsmatorg.apache.commons.lang.WordUtilschorg.apache.commons.lang.WordUtils 
  }
}
