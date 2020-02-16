package Java.Solution.S0001;

import org.junit.Assert;
import org.junit.Test;

public class S0001Test {

  @Test
  public void longestPalindromeTest() {
    S0001 s0001 = new S0001();

    int[] nums1 = new int[]{2, 11, 7, 5};
    int[] poss1 = s0001.twoSum(nums1, 9);
    Assert.assertTrue(poss1[0] == 0);
    Assert.assertTrue(poss1[1] == 2);

    int[] nums2 = new int[]{};
    int[] poss2 = s0001.twoSum(nums2, 9);
    Assert.assertTrue(poss2.length == 0);
  }
}
