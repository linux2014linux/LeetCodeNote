package Java.Solution.S0004;

public class S0004 {

  /**
   * 思想:
   * 时间复杂度: O(log(min(x, y))
   * 参考链接: https://www.youtube.com/watch?v=LPFhl65R7ww
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int xLen = nums1.length, yLen = nums2.length;
    int start = 0, end = xLen;
    while (start <= end) {
      int partionX = (start + end) / 2; // X左部分元素的数量
      int partionY = (xLen + yLen + 1) / 2 - partionX; // Y左部分的元素数量

      int maxLeftX = partionX == 0 ? Integer.MIN_VALUE : nums1[partionX - 1];
      int minRightX = partionX == xLen ? Integer.MAX_VALUE : nums1[partionX];

      int maxLeftY = partionY == 0 ? Integer.MIN_VALUE : nums2[partionY - 1];
      int minRightY = partionY == yLen ? Integer.MAX_VALUE : nums2[partionY];

      if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
        if ((xLen + yLen) % 2 == 0) { // 偶数个数字
          return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))) / 2;
        }
        return (double) Math.max(maxLeftX, maxLeftY);
      } else if (maxLeftX > minRightY) {
        end = partionX - 1;
      } else {
        start = partionX + 1;
      }
    }

    return 0.0;
  }

  /**
   * 思想: 第K大元素
   * 时间复杂度: O(log(m + n))
   * TODO 该算法有待仔细分析
   */
  public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int left = (m + n + 1) / 2;
    int right = (m + n + 2) / 2;
    return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
  }

  // i: nums1的起始位置 j: nums2的起始位置
  public int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
    if (i >= nums1.length) {
      return nums2[j + k - 1];//nums1为空数组
    }
    if (j >= nums2.length) {
      return nums1[i + k - 1];//nums2为空数组
    }
    if (k == 1) {
      return Math.min(nums1[i], nums2[j]);
    }
    int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
    int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
    if (midVal1 < midVal2) {
      return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
    } else {
      return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
    }
  }
}
