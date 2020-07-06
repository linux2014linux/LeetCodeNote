package Java.Solution.S0084;

import org.junit.Assert;
import org.junit.Test;

public class S0084Test {

  @Test
  public void test1() {
    S0084 s0084 = new S0084();
    int[] heights = {2, 1, 5, 6, 2, 3};
    Assert.assertTrue(s0084.way1(heights) == 10);
  }

  @Test
  public void test2() {
    S0084 s0084 = new S0084();
    int[] heights = {1};
    Assert.assertTrue(s0084.way1(heights) == 1);
  }

  @Test
  public void test3() {
    S0084 s0084 = new S0084();
    int[] heights = {2, 1, 2};
    Assert.assertTrue(s0084.way1(heights) == 3);
  }

  @Test
  public void testA() {
    S0084 s0084 = new S0084();
    int[] heights = {2, 1, 5, 6, 2, 3};
    Assert.assertTrue(s0084.way2(heights) == 10);
  }

  @Test
  public void testB() {
    S0084 s0084 = new S0084();
    int[] heights = {1};
    Assert.assertTrue(s0084.way2(heights) == 1);
  }

  @Test
  public void testC() {
    S0084 s0084 = new S0084();
    int[] heights = {2, 1, 2};
    Assert.assertTrue(s0084.way2(heights) == 3);
  }

  @Test
  public void testD() {
    S0084 s0084 = new S0084();
    int[] heights = {4, 2, 0, 3, 2, 5};
    Assert.assertTrue(s0084.way2(heights) == 6);
  }
}
