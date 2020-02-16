package Java.Solution.S0001;

import java.util.HashMap;
import java.util.Map;

public class S0001 {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numPositionMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num1 = nums[i];
      int num2 = target - num1;
      if (numPositionMap.containsKey(num2)) {
        return new int[]{numPositionMap.get(num2), i};
      }
      numPositionMap.put(nums[i], i);
    }

    return new int[0];
  }
}
