package Java.Solution.Other.Sort;

public class QuickSort {

  public void sort(int[] nums, int l, int r) {
    if (l < r) {
      int start = l, end = r, cur = nums[l];
      while (start < end) {
        while (start < end && nums[end] >= cur) { // 右边找小的
          end--;
        }
        if (start < end) { // 小的放前面
          nums[start] = nums[end];
          start++;
        }

        while (start < end && nums[start] <= cur) { // 左边找大的
          start++;
        }
        if (start < end) { // 大的放后面
          nums[end] = nums[start];
          end--;
        }
      }
      nums[start] = cur;
      sort(nums, l, start - 1);
      sort(nums, start + 1, r);
    }
  }
}