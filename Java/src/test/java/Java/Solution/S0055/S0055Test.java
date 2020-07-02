package Java.Solution.S0055;

import org.junit.Assert;
import org.junit.Test;

public class S0055Test {

  @Test
  public void test1() {
    S0055 s0055 = new S0055();
    int[] nums = {2, 3, 1, 1, 4};
    Assert.assertTrue(s0055.canJump(nums));
  }

  @Test
  public void test2() {
    S0055 s0055 = new S0055();
    int[] nums = {3, 2, 1, 0, 4};
    Assert.assertFalse(s0055.canJump(nums));
  }

  @Test
  public void test3() {
    S0055 s0055 = new S0055();
    int[] nums = {2, 3, 1, 1, 4};
    Assert.assertTrue(s0055.canJump(nums));
  }

  @Test
  public void test4() {
    S0055 s0055 = new S0055();
    int[] nums = {0};
    Assert.assertTrue(s0055.canJump(nums));
  }

  @Test
  public void test5() {
    S0055 s0055 = new S0055();
    int[] nums = {0, 2, 3};
    Assert.assertFalse(s0055.canJump(nums));
  }
}
