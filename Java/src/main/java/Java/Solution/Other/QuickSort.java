package Java.Solution.Other;

public class QuickSort {
  public static void quickSort(int[] nums, int l, int r) {
    if (l < r) {
      int start = l, end = r, cur = nums[l];
      while (start < end) {
        while (start < end && nums[end] >= cur) { // 从右边找比当前数小的值
          end--;
        }
        if (start < end) {
          nums[start] = nums[end];
          start++;
        }

        while (start < end && nums[start] <= cur) { // 找左边找比当前数大的值
          start++;
        }
        if (start < end) {
          nums[end] = nums[start];
          end--;
        }
      }
      nums[start] = cur;
      quickSort(nums, l, start - 1);
      quickSort(nums, start + 1, r);
    }
  }
}
