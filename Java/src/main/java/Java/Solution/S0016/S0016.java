package Java.Solution.S0016;

import java.util.Arrays;

public class S0016 {

  /**
   * 排序 + 左右两侧指针
   * @param nums
   * @param target
   * @return
   */
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int sumClosest = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; i++) {
      int start = i + 1, end = nums.length - 1;
      while (start < end) {
        int sumCurrent = nums[i] + nums[start] + nums[end];
        if (Math.abs(target - sumCurrent) < Math.abs(target - sumClosest)) {
          sumClosest = sumCurrent;
        }
        if (sumCurrent < target) {
          start++;
          while (start < end && nums[start] == nums[start - 1]) { // 过滤左侧相同的元素
            start++;
          }
        } else if (sumCurrent > target) {
          end--;
          while (start < end && nums[end] == nums[end + 1]) { // 过滤右侧相同的元素
            end--;
          }
        } else {
          break;
        }
      }
      while (i < nums.length - 2 && nums[i] == nums[i + 1]) { // 过滤当前相同元素
        i++;
      }
    }
    return sumClosest;
  }
}
