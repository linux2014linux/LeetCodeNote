package Java.Solution.S0042;

public class S0042 {
  public int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int rangeMaxSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      rangeMaxSum = Math.max(rangeMaxSum + nums[i], nums[i]); // 以当前位置结尾的子数组最大和
      maxSum = Math.max(rangeMaxSum, maxSum); // 截至目前未知的全局最大和
    }
    return maxSum;
  }
}
