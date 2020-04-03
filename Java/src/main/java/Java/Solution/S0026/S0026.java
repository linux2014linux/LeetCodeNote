package Java.Solution.S0026;

public class S0026 {
  public int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len < 1) {
      return 0;
    }

    int count = 0;
    int prevNum = nums[count++];
    for (int i = 1; i < len; i++) {
      if (nums[i] != prevNum) {
        prevNum = nums[i];
        nums[count++] = nums[i];
      }
    }

    return count;
  }
}
