/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 13:51:22 GMT 2019
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
      // Undeclared exception!
      try { 
        WordUtils.abbreviate("Windows 9", (-3200), (-37), "Y1^");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      String string0 = WordUtils.abbreviate(" ", (-2753), 0, "O");
      assertEquals("O", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      String string0 = WordUtils.abbreviate("^Wi#tC|c7-2^jq", 0, 2, (String) null);
      assertEquals("^W", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      String string0 = WordUtils.abbreviate("t \"zy\"4A@V", 1, 10, "");
      assertEquals("t", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      String string0 = WordUtils.abbreviate("uWk&/\"pUm,Px)_m-hP5", 4817, 4817, "q<hV(r");
      assertEquals("uWk&/\"pUm,Px)_m-hP5", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      String string0 = WordUtils.abbreviate("b", 1, 0, "o#}&>");
      assertEquals("b", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      String string0 = WordUtils.wrap(" \t\r\n\b", (-1), (String) null, true);
      assertEquals("\t\n\r\n\n\n\b", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      String string0 = WordUtils.initials((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      String string0 = WordUtils.initials("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      String string0 = WordUtils.capitalize((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      String string0 = WordUtils.initials("D6M0", (char[]) null);
      assertEquals("D", string0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      char[] charArray0 = new char[3];
      charArray0[1] = 'f';
      String string0 = WordUtils.wrap("'; the SystemUtils property value will default to null.", (-1), "'; the SystemUtils property value will default to null.", true);
      // Undeclared exception!
      WordUtils.uncapitalize(string0, charArray0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      char[] charArray0 = new char[2];
      String string0 = WordUtils.uncapitalize("dU^G,R]F#zKw;$", charArray0);
      assertEquals("dU^G,R]F#zKw;$", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      char[] charArray0 = new char[2];
      String string0 = WordUtils.uncapitalize((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("", (char[]) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      char[] charArray0 = new char[1];
      String string0 = WordUtils.capitalizeFully("O#}&>", charArray0);
      assertEquals("O#}&>", string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      char[] charArray0 = new char[1];
      String string0 = WordUtils.capitalizeFully((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("", (char[]) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      char[] charArray0 = new char[2];
      charArray0[1] = 'X';
      String string0 = WordUtils.capitalize(";u0@#XEg%}+,GK", charArray0);
      assertEquals(";u0@#XEg%}+,GK", string0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalize("", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      String string0 = WordUtils.capitalize("1+5bH>3'O~X", (char[]) null);
      assertEquals("1+5bH>3'O~X", string0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      String string0 = WordUtils.wrap("Was U\fn]Sh0", (-792), "H", false);
      assertEquals("WasHU\fn]Sh0", string0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      String string0 = WordUtils.wrap("&!rHvAVT=GY", 9, ")&.^e4<d0", true);
      assertEquals("&!rHvAVT=)&.^e4<d0GY", string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      String string0 = WordUtils.wrap((String) null, 0, "java.vm.name", true);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      String string0 = WordUtils.abbreviate(" is less than 0: ", 10, 10, "org.apache.commons.lang.WordUtils");
      assertEquals(" is less torg.apache.commons.lang.WordUtils", string0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      String string0 = WordUtils.abbreviate("LINUX", (-1), (-1), "");
      assertEquals("LINUX", string0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      String string0 = WordUtils.abbreviate("", (-2072), 62, "");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      String string0 = WordUtils.abbreviate((String) null, 3037, 3037, "xF#nJJc");
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      char[] charArray0 = new char[1];
      charArray0[0] = '%';
      String string0 = WordUtils.initials("FG0#Wh&/%#G", charArray0);
      assertEquals("F#", string0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.initials("k?dM4G9rFh?4bk]", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.initials("", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      char[] charArray0 = new char[2];
      String string0 = WordUtils.initials((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      String string0 = WordUtils.swapCase("y");
      assertEquals("Y", string0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      String string0 = WordUtils.swapCase("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      String string0 = WordUtils.swapCase("PwD|t7sK'nNdI:");
      assertEquals("pWd|T7Sk'NnDi:", string0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      String string0 = WordUtils.swapCase((String) null);
      assertNull(string0);
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
      String string0 = WordUtils.uncapitalize("xF#nJJc", charArray0);
      assertEquals("xF#nJJc", string0);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("o");
      assertEquals("O", string0);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalizeFully("xF#nJJc", charArray0);
      assertEquals("xF#nJJc", string0);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalize("xF#nJJc", charArray0);
      assertEquals("xF#nJJc", string0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      String string0 = WordUtils.capitalize("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalize((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      String string0 = WordUtils.wrap("` p; d}:M26", 0);
      assertNotNull(string0);
      assertEquals("`\np;\nd}:M26", string0);
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      String string0 = WordUtils.wrap("", 0, "", true);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      String string0 = WordUtils.wrap((String) null, 2299);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      WordUtils wordUtils0 = new WordUtils();
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("y5g O>RJ!");
      assertEquals("y5g o>RJ!", string0);
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      String string0 = WordUtils.wrap("", 0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      String string0 = WordUtils.initials("oh");
      assertEquals("o", string0);
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      String string0 = WordUtils.capitalize("xnaY -YU!H]hGT");
      assertEquals("XnaY -YU!H]hGT", string0);
  }
}
