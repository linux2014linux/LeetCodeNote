package Java.Solution.Other.Probability;

import org.junit.Assert;
import org.junit.Test;

public class P1Test {

  @Test
  public void test1() {
    P1 p1 = new P1();
    Assert.assertTrue(p1.s1(1, 2) == 0.75);
    long st = System.currentTimeMillis() / 1000;
    System.out.println(p1.s1(30, 31));
    System.out.println(System.currentTimeMillis() / 1000 - st);
  }

  @Test
  public void test2() {
    P1 p1 = new P1();
    Assert.assertTrue(p1.s2(1, 2) == 0.75);
    // 0.5512890865042848
    System.out.println(p1.s2(30, 31));
  }
}
