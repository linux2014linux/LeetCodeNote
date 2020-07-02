package Java.Solution.S0055;

public class S0055 {
  public boolean canJump(int[] nums) {

    int curMaxRange = 0;
    int length = nums.length;
    int end = length - 1;
    for (int i = 0; i < length; i++) {
      int num = nums[i];
      if (curMaxRange >= i) { // 能否到达当前位置
        curMaxRange = Math.max(num + i, curMaxRange); // 当前位置能够跳跃到的最大位置
        if (curMaxRange >= end) {
          return true;
        }
      }
    }

    return false;
  }
}
