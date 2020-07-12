package Java.Solution.Other.Sort;

public class HeapSort {

  public void sort(int[] nums) {
    if (nums == null || nums.length < 1) {
      return;
    }
    int length = nums.length;

    buildHeap(nums, length);
    for (int i = length - 1; i >= 0; i--) {
      swap(nums, 0, i);
      heapify(nums, i, 0);
    }
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  private void buildHeap(int[] nums, int length) {
    int end = length - 1;
    int endP = (end - 1) / 2; // 末尾非叶结点
    for (int i = endP; i >= 0; i--) {
      heapify(nums, length, i);
    }
  }

  /**
   * @param nums
   * @param n 结点数
   * @param i 结点下标
   */
  private void heapify(int[] nums, int n, int i) {
    if (i >= n) {
      return;
    }

    int lc = 2 * i + 1;
    int rc = 2 * i + 2;
    int min = i;
    if (lc < n && nums[lc] < nums[min]) {
      min = lc;
    }
    if (rc < n && nums[rc] < nums[min]) {
      min = rc;
    }

    if (min != i) {
      swap(nums, i, min);
      heapify(nums, n, min);
    }
  }
}
