/*
 * This file was automatically generated by EvoSuite
 * Sat Mar 16 13:03:59 GMT 2019
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
      String string0 = WordUtils.abbreviate("i.YTO=A_ k{hu.1", (-2000), 0, "");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      String string0 = WordUtils.abbreviate(" ", 0, 0, "}3:2>fk:1");
      assertEquals("}3:2>fk:1", string0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      String string0 = WordUtils.abbreviate("0-E1f!nh?:v`24f|#]l", 2166, (-1218), "1,HGRz!631");
      assertEquals("0-E1f!nh?:v`24f|#]l", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      char[] charArray0 = new char[9];
      String string0 = WordUtils.uncapitalize("}3:2>fk:1", charArray0);
      assertEquals("}3:2>fk:1", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      char[] charArray0 = new char[1];
      String string0 = WordUtils.capitalizeFully(")|pt{,ZXZnfEiX", charArray0);
      assertEquals(")|pt{,zxznfeix", string0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      String string0 = WordUtils.wrap("(Py:9 YF!pG'Y|Yg0", (-187), "D^9g2(/;gY*JD", true);
      assertEquals("(D^9g2(/;gY*JDPD^9g2(/;gY*JDyD^9g2(/;gY*JD:D^9g2(/;gY*JD9D^9g2(/;gY*JDYD^9g2(/;gY*JDFD^9g2(/;gY*JD!D^9g2(/;gY*JDpD^9g2(/;gY*JDGD^9g2(/;gY*JD'D^9g2(/;gY*JDYD^9g2(/;gY*JD|D^9g2(/;gY*JDYD^9g2(/;gY*JDgD^9g2(/;gY*JD0", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      String string0 = WordUtils.wrap("", (-967), ",$h\"XbLl-*p,Bc.;", true);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      String string0 = WordUtils.wrap((String) null, 3590);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      String string0 = WordUtils.uncapitalize((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      String string0 = WordUtils.initials((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      String string0 = WordUtils.initials("Z^AwnX['!K");
      assertEquals("Z", string0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      // Undeclared exception!
      try { 
        WordUtils.abbreviate("`U0G<6iPB1cYi-aV!3[", (-629), (-629), "java.class.path");
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      String string0 = WordUtils.initials("e)ttIWt:+J|ZH.tq", (char[]) null);
      assertEquals("e", string0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      String string0 = WordUtils.initials("", (char[]) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      String string0 = WordUtils.uncapitalize(" ", (char[]) null);
      assertEquals(" ", string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("", (char[]) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("", (char[]) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      char[] charArray0 = new char[5];
      String string0 = WordUtils.capitalizeFully((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("Ufl?6~|`vj6reXfDUv", (char[]) null);
      assertEquals("Ufl?6~|`vj6rexfduv", string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      String string0 = WordUtils.capitalize(" ", (char[]) null);
      assertEquals(" ", string0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      char[] charArray0 = new char[3];
      String string0 = WordUtils.capitalize((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      String string0 = WordUtils.capitalize("", (char[]) null);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      String string0 = WordUtils.capitalize("&DH", (char[]) null);
      assertEquals("&DH", string0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      String string0 = WordUtils.wrap("@/ETA< R", 918, (String) null, true);
      assertEquals("@/ETA< R", string0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      String string0 = WordUtils.abbreviate(": (H=])<76jojBd", (-380), 1848, "");
      assertEquals(":", string0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      String string0 = WordUtils.abbreviate(")|pt{,ZXZnfEiX", 1, 1, "java.specification.version");
      assertEquals(")java.specification.version", string0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      String string0 = WordUtils.abbreviate("T", (-1), (-1), "");
      assertEquals("T", string0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      String string0 = WordUtils.abbreviate("", 48, 0, "");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      String string0 = WordUtils.abbreviate((String) null, 3, (-187), "");
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      String string0 = WordUtils.abbreviate(" ", 1, 1, (String) null);
      assertEquals(" ", string0);
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      char[] charArray0 = new char[8];
      charArray0[4] = 'P';
      String string0 = WordUtils.initials("\\(Py:9 YF!pG'Y|Yg0((Py:9 YF!pG'Y|Yg0P(Py:9 YF!pG'Y|Yg0y(Py:9 YF!pG'Y|Yg0:(Py:9 YF!pG'Y|Yg09(Py:9 YF!pG'Y|Yg0Y(Py:9 YF!pG'Y|Yg0F(Py:9 YF!pG'Y|Yg0!(Py:9 YF!pG'Y|Yg0p(Py:9 YF!pG'Y|Yg0G(Py:9 YF!pG'Y|Yg0'(Py:9 YF!pG'Y|Yg0Y(Py:9 YF!pG'Y|Yg0|(Py:9 YF!pG'Y|Yg0Y(Py:9 YF!pG'Y|Yg0g(Py:9 YF!pG'Y|Yg00", charArray0);
      assertEquals("\\yy(yyyyyyyyyyyyyy", string0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.initials("K$/X", charArray0);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      String string0 = WordUtils.initials("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      char[] charArray0 = new char[1];
      String string0 = WordUtils.initials((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      String string0 = WordUtils.swapCase("wAew uQ$Uj");
      assertEquals("WaEW Uq$uJ", string0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      String string0 = WordUtils.swapCase("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      String string0 = WordUtils.swapCase((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("_2[rh ^K#vs");
      assertEquals("_2[rh ^K#vs", string0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.uncapitalize("T", charArray0);
      assertEquals("T", string0);
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.uncapitalize((String) null, charArray0);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalizeFully("p1D&!o:nx~@oQ", charArray0);
      assertEquals("p1D&!o:nx~@oQ", string0);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      String string0 = WordUtils.capitalize(" =fC]\"d;ro$|JYx");
      assertEquals(" =fC]\"d;ro$|JYx", string0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully("j<!i}(&");
      assertEquals("J<!i}(&", string0);
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      String string0 = WordUtils.capitalize("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      char[] charArray0 = new char[0];
      String string0 = WordUtils.capitalize(")|pt{,ZXZnfEiX", charArray0);
      assertEquals(")|pt{,ZXZnfEiX", string0);
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      String string0 = WordUtils.wrap(" =fC]\"d;ro$|JYx", (-1093));
      assertEquals("=fC]\"d;ro$|JYx", string0);
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      String string0 = WordUtils.wrap("Hv P0I", (-1558), "", false);
      assertEquals("HvP0I", string0);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      String string0 = WordUtils.wrap((String) null, 1, "", false);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      WordUtils wordUtils0 = new WordUtils();
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      String string0 = WordUtils.uncapitalize("");
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      String string0 = WordUtils.wrap("", 1);
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      String string0 = WordUtils.capitalizeFully((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      String string0 = WordUtils.capitalize((String) null);
      assertNull(string0);
  }
}