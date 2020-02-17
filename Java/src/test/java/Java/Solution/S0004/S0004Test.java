package Java.Solution.S0004;

import org.junit.Test;

public class S0004Test {

  @Test
  public void findMedianSortedArraysTest() {
    S0004 s0004 = new S0004();

    int[] nums1 = {2};
    int[] nums2 = {1, 3};
    System.out.println(s0004.findMedianSortedArrays(nums1, nums2));
  }
}
