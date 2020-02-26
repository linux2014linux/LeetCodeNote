package Java.Solution.S0673;

import org.junit.Assert;
import org.junit.Test;

public class S0673Test {

  @Test
  public void test1() {
    S0673 s0673 = new S0673();
    int[] nums0 = new int[0];
    Assert.assertTrue(s0673.findNumberOfLIS(nums0) == 0);

    int[] nums1 = {19, 3, 5, 4, 7};
    Assert.assertTrue(s0673.findNumberOfLIS(nums1) == 2);

    int[] nums2 = {3, 3, 3, 3, 3};
    Assert.assertTrue(s0673.findNumberOfLIS(nums2) == 5);

    int[] nums3 = {4, 5, 9, 10, 12};
    Assert.assertTrue(s0673.findNumberOfLIS(nums3) == 1);
  }

  @Test
  public void test2() {
    S0673 s0673 = new S0673();
    int[] nums0 = new int[0];
    Assert.assertTrue(s0673.findNumberOfLIS2(nums0) == 0);

    int[] nums1 = {19, 3, 5, 4, 7};
    Assert.assertTrue(s0673.findNumberOfLIS2(nums1) == 2);

    int[] nums2 = {3, 3, 3, 3, 3};
    Assert.assertTrue(s0673.findNumberOfLIS2(nums2) == 5);

    int[] nums3 = {4, 5, 9, 10, 12};
    Assert.assertTrue(s0673.findNumberOfLIS2(nums3) == 1);
  }
}
