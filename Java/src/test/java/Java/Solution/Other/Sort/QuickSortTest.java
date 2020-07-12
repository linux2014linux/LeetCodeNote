package Java.Solution.Other.Sort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

  @Test
  public void test1() {
    int[] nums = {3, 9, 1, 7, 8, 6, 5};
    int[] target = {1, 3, 5, 6, 7, 8, 9};
    QuickSort quickSort = new QuickSort();
    quickSort.sort(nums, 0, nums.length - 1);
    for (int i = 0; i < nums.length; i++) {
      Assert.assertTrue(nums[i] == target[i]);
    }
  }
}
