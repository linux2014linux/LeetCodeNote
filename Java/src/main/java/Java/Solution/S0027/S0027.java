package Java.Solution.S0027;

public class S0027 {
  public int removeElement(int[] nums, int val) {
    int len = nums.length;
    int countOfEqualVal = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] != val) {
        nums[countOfEqualVal++] = nums[i];
      }
    }

    return countOfEqualVal;
  }
}
