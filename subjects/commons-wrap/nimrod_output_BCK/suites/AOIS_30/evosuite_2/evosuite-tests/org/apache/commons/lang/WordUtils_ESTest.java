/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 13:11:13 GMT 2019
 */

package org.apache.commons.lang;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.lang.WordUtils;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class WordUtils_ESTest extends WordUtils_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      String string0 = WordUtils.abbreviate("Caught a SecurityException reading the system property '", 0, 2, "E0QwRU");
      assertEquals("CaE0QwRU", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      String string0 = WordUtils.abbreviate(" ", 0, 0, "1?xygmnvuq");
      assertEquals("1?xygmnvuq", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      String string0 = WordUtils.abbreviate("3", 1, 1, "mJL+,-~G{O");
      assertEquals("3", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      String string0 = WordUtils.abbreviate("o", 1, 2, " ");
      assertEquals("o", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      char[] charArray0 = new char[2];
      String string0 = WordUtils.uncapitalize(" ", charArray0);
      assertEquals(" ", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      String string0 = WordUtils.wrap("l_YP 6t?5^Hxs*0D", (-1368), "OQn=-q(7yMdn", true);
      assertEquals("lOQn=-q(7yMdn_OQn=-q(7yMdnYOQn=-q(7yMdnPOQn=-q(7yMdn6OQn=-q(7yMdntOQn=-q(7yMdn?OQn=-q(7yMdn5OQn=-q(7yMdn^OQn=-q(7yMdnHOQn=-q(7yMdnxOQn=-q(7yMdnsOQn=-q(7yMdn*OQn=-q(7yMdn0OQn=-q(7yMdnD", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      String string0 = WordUtils.wrap("-b}_l\ti0&{C{\u0000", 0, "-b}_l\ti0&{C{\u0000", true);
      assertEquals("--b}_l\ti0&{C{\u0000b-b}_l\ti0&{C{\u0000}-b}_l\ti0&{C{\u0000_-b}_l\ti0&{C{\u0000l-b}_l\ti0&{C{\u0000\t-b}_l\ti0&{C{\u0000i-b}_l\ti0&{C{\u00000-b}_l\ti0&{C{\u0000&-b}_l\ti0&{C{\u0000{-b}_l\ti0&{C{\u0000C-b}_l\ti0&{C{\u0000{-b}_l\ti0&{C{\u0000\u0000", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      String string0 = WordUtils.wrap((String) null, 0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      String string0 = WordUtils.wrap("", (-3046));
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      String string0 = WordUtils.initials("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      String string0 = WordUtils.capitalize((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      String string0 = WordUtils.capitalize("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      // Undeclared exception!
      try { 
        WordUtils.abbreviate("-PSjWZv8u", (-3270), (-989), "Windows NT");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      String string0 = WordUtils.initials("Windows NT", (char[]) null);
      assertEquals("WN", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      char[] charArray0 = new char[2];
      String string0 = WordUtils.initials((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      char[] charArray0 = new char[4];
      String string0 = WordUtils.uncapitalize((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.uncapitalize("", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      char[] charArray0 = new char[8];
      charArray0[0] = '$';
      String string0 = WordUtils.capitalize("JlJl_BX8`h-I$XhEiPk0i", charArray0);
      assertEquals("JlJl_BX8`h-I$XhEiPk0i", string0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      String string0 = WordUtils.capitalize("org.apache.commons.lang.WordUtils", (char[]) null);
      assertEquals("Org.apache.commons.lang.WordUtils", string0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      String string0 = WordUtils.wrap("", (-3356), (String) null, true);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      String string0 = WordUtils.abbreviate("$/A$/A \\(_tP2 v=\\(_tP2$/A \\(_tP2 v=v=", 7, 80, "%:3))");
      assertEquals("$/A$/A \\(_tP2%:3))", string0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      String string0 = WordUtils.abbreviate("Org.apache.commons.lang.WordUtils", 2, 0, "");
      assertEquals("Or", string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      String string0 = WordUtils.abbreviate("MU)1yBRnl_[%0", (-3334), (-1), (String) null);
      assertEquals("MU)1yBRnl_[%0", string0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      String string0 = WordUtils.abbreviate("j.", 16, 16, "J.");
      assertEquals("j.", string0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      String string0 = WordUtils.abbreviate((String) null, (-11), 0, "xZ|JDQ");
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      String string0 = WordUtils.abbreviate("", (-3046), (-3046), "KML6W`W'$+");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      char[] charArray0 = new char[8];
      charArray0[2] = 'w';
      String string0 = WordUtils.initials("\"9g>bwin", charArray0);
      assertEquals("\"i", string0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.initials("3J#H/^", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      char[] charArray0 = new char[1];
      String string0 = WordUtils.initials("", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      String string0 = WordUtils.initials((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      String string0 = WordUtils.swapCase("LrM'z!8iQxU+;d/Dt");
      assertEquals("lRm'Z!8IqXu+;D/dT", string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      String string0 = WordUtils.swapCase("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      String string0 = WordUtils.swapCase("xZ|JDQ");
      assertEquals("Xz|jdq", string0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      String string0 = WordUtils.swapCase((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("56l^BV bavom!e", (char[]) null);
      assertEquals("56l^BV bavom!e", string0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      String string0 = WordUtils.uncapitalize((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.uncapitalize(" ", charArray0);
      assertEquals(" ", string0);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalizeFully("j.", charArray0);
      assertEquals("j.", string0);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("", (char[]) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      char[] charArray0 = new char[3];
      String string0 = WordUtils.capitalizeFully((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("$/A \\(_tP2 v=", (char[]) null);
      assertEquals("$/a \\(_tp2 V=", string0);
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalize("-CpH", charArray0);
      assertEquals("-CpH", string0);
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalize("", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      char[] charArray0 = new char[1];
      String string0 = WordUtils.capitalize((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      char[] charArray0 = new char[3];
      String string0 = WordUtils.capitalizeFully(" ", charArray0);
      assertEquals(" ", string0);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      String string0 = WordUtils.wrap("$/A \\(_tP2 v=", (-1092), "$/A \\(_tP2 v=", false);
      assertEquals("$/A$/A \\(_tP2 v=\\(_tP2$/A \\(_tP2 v=v=", string0);
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      String string0 = WordUtils.wrap("", 2437, "", true);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      String string0 = WordUtils.wrap((String) null, (-1868), "5{", false);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      WordUtils wordUtils0 = new WordUtils();
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("org.apache.commons.lang.WordUtils");
      assertEquals("org.apache.commons.lang.WordUtils", string0);
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      String string0 = WordUtils.wrap(">r0rS", 0);
      assertNotNull(string0);
      assertEquals(">r0rS", string0);
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      String string0 = WordUtils.initials("Org.apache.commons.lang.wordutils");
      assertEquals("O", string0);
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("7");
      assertEquals("7", string0);
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      String string0 = WordUtils.capitalize("oRg.apache.coMmoNs.lang.woRdutils");
      assertEquals("ORg.apache.coMmoNs.lang.woRdutils", string0);
  }
}
