package Java.Solution.Other.Sort;

import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {

  @Test
  public void test1() {
    int[] nums = {2, 5, 3, 1, 10, 4};
    int[] target = {10, 5, 4, 3, 2, 1};
    HeapSort heapSort = new HeapSort();
    heapSort.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      Assert.assertTrue(nums[i] == target[i]);
    }
  }
}
