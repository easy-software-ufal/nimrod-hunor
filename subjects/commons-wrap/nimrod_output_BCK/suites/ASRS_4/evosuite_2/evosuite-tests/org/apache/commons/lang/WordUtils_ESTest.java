/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 14:34:14 GMT 2019
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
      WordUtils.abbreviate("p 2|OPK4J`'H?", (-1), 0, "P 2|OPK4J`'H?");
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      WordUtils.abbreviate(" ", (-778), 0, " ");
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      WordUtils.abbreviate("*~", 0, 2, "Z(h8hQsrH");
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      WordUtils.abbreviate(" ", 1, 1, " ");
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      WordUtils.wrap("", 0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      WordUtils.uncapitalize((String) null);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      WordUtils.initials((String) null);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      WordUtils.capitalizeFully("java.runtime.name");
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      WordUtils.capitalize((String) null);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      WordUtils.capitalize("\n|.]~HQd;c[oS$iZz");
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      String string0 = WordUtils.wrap("org.apache.commons.lang.WordUtils", (-1), "org.apache.commons.lang.WordUtils", true);
      char[] charArray0 = new char[5];
      String string1 = WordUtils.capitalize(string0, charArray0);
      // Undeclared exception!
      WordUtils.capitalize(string1, charArray0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      // Undeclared exception!
      try { 
        WordUtils.abbreviate(" ", (-924), (-1155), " ");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      String string0 = WordUtils.initials("Windows 9", (char[]) null);
      assertEquals("W9", string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      char[] charArray0 = new char[4];
      String string0 = WordUtils.initials("", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      char[] charArray0 = new char[3];
      charArray0[2] = 'v';
      String string0 = WordUtils.uncapitalize("_v0&VFvNQ{p", charArray0);
      assertEquals("_v0&VFvnQ{p", string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      char[] charArray0 = new char[3];
      String string0 = WordUtils.uncapitalize("", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalizeFully("", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      char[] charArray0 = new char[3];
      String string0 = WordUtils.capitalizeFully((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("j", (char[]) null);
      assertEquals("J", string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      String string0 = WordUtils.wrap("org.apache.commons.lang.WordUtils", (-1), "org.apache.commons.lang.WordUtils", true);
      char[] charArray0 = new char[5];
      charArray0[4] = 'r';
      String string1 = WordUtils.capitalize(string0, charArray0);
      assertFalse(string1.equals((Object)string0));
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      String string0 = WordUtils.wrap("", 2136, (String) null, true);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      String string0 = WordUtils.wrap((String) null, 0, (String) null, false);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      String string0 = WordUtils.abbreviate(" =tf1o{", 0, 75, "=Mac OS XtMac OS XfMac OS X1Mac OS XoMac OS X{");
      assertEquals("=Mac OS XtMac OS XfMac OS X1Mac OS XoMac OS X{", string0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      String string0 = WordUtils.abbreviate(":.,-v:bxXe7 _yI", (-1), (-1), ":.,-v:bxXe7 _yI");
      assertEquals(":.,-v:bxXe7:.,-v:bxXe7 _yI", string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      String string0 = WordUtils.abbreviate("line.separator", 4517, 5, "0");
      assertEquals("line.separator", string0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      String string0 = WordUtils.abbreviate("", 5, 0, "");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      String string0 = WordUtils.abbreviate((String) null, 0, 0, (String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      String string0 = WordUtils.abbreviate("org.apache.commons.lang.WordUtils", 2, (-1704), "sy)-mqw ");
      assertNotNull(string0);
      assertEquals("orsy)-mqw ", string0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      char[] charArray0 = new char[3];
      String string0 = WordUtils.initials("_v0&VFvnQ{p", charArray0);
      assertEquals("_", string0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.initials("org.apache.commons.lang.WordUtils", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      String string0 = WordUtils.initials("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      String string0 = WordUtils.initials((String) null, (char[]) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      String string0 = WordUtils.swapCase("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      String string0 = WordUtils.swapCase("org.apache.commons.lang.WordUtils");
      assertEquals("ORG.APACHE.COMMONS.LANG.wORDuTILS", string0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      String string0 = WordUtils.swapCase((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("Lhm.thw<1 bs");
      assertEquals("lhm.thw<1 bs", string0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      String string0 = WordUtils.uncapitalize((String) null, (char[]) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.uncapitalize("org.apache.commons.lang.WordUtils", charArray0);
      assertEquals("org.apache.commons.lang.WordUtils", string0);
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalizeFully("Lhm.thw<1 bs", charArray0);
      assertEquals("Lhm.thw<1 bs", string0);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      char[] charArray0 = new char[4];
      charArray0[0] = '0';
      String string0 = WordUtils.capitalizeFully("0-?4:)%4b ", charArray0);
      assertEquals("0-?4:)%4b ", string0);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalize("file.separator", charArray0);
      assertEquals("file.separator", string0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      String string0 = WordUtils.capitalize((String) null, (char[]) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      char[] charArray0 = new char[5];
      String string0 = WordUtils.capitalize("", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      String string0 = WordUtils.wrap(" vs ", (-426), "?", false);
      assertEquals("vs?", string0);
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      String string0 = WordUtils.wrap("=Mac OS XtMac OS XfMac OS X1Mac OS XoMac OS X{", 0, "$@!RB", true);
      assertEquals("=$@!RBM$@!RBa$@!RBc$@!RBO$@!RBS$@!RBX$@!RBt$@!RBM$@!RBa$@!RBc$@!RBO$@!RBS$@!RBX$@!RBf$@!RBM$@!RBa$@!RBc$@!RBO$@!RBS$@!RBX$@!RB1$@!RBM$@!RBa$@!RBc$@!RBO$@!RBS$@!RBX$@!RBo$@!RBM$@!RBa$@!RBc$@!RBO$@!RBS$@!RBX$@!RB{", string0);
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      String string0 = WordUtils.wrap("org.apache.commons.lang.WordUtils", (-1), "org.apache.commons.lang.WordUtils", true);
      String string1 = WordUtils.wrap(string0, 4, string0, false);
      assertTrue(string1.equals((Object)string0));
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      String string0 = WordUtils.wrap(" =tf1o{", 0);
      assertEquals("=tf1o{", string0);
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      WordUtils wordUtils0 = new WordUtils();
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      String string0 = WordUtils.wrap((String) null, 0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      String string0 = WordUtils.initials("0-?4:)%4b ");
      assertEquals("0", string0);
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      String string0 = WordUtils.capitalize("");
      assertEquals("", string0);
  }
}