package Java.Solution.S0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0018 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    int numCount = nums.length;
    List<List<Integer>> resultList = new ArrayList<>();
    if (numCount < 4) {
      return resultList;
    }

    Arrays.sort(nums);
    for (int i = 0; i < numCount - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int minFourSum = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
      if (minFourSum > target) {
        break;
      }
      int maxFourSum = nums[i] + nums[numCount - 3] + nums[numCount - 2] + nums[numCount - 1];
      if (maxFourSum < target) {
        continue;
      }

      int threeSum = target - nums[i];
      for (int j = i + 1; j < numCount - 2; j++) {
        if (j != i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int minThreeSum = nums[j] + nums[j + 1] + nums[j + 2];
        if (minThreeSum > threeSum) {
          break;
        }
        int maxThreeSum = nums[j] + nums[numCount - 2] + nums[numCount - 1];
        if (maxThreeSum < threeSum) {
          continue;
        }

        int twoSum = threeSum - nums[j];
        int start = j + 1, end = numCount - 1;
        while (start < numCount && end > 0 && start < end) {
          int curTwoSum = nums[start] + nums[end];
          if (curTwoSum == twoSum) {
            resultList.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
            start++;
            end--;
          } else if (curTwoSum > twoSum) {
            end--;
          } else {
            start++;
          }

          while (start > j + 1 && start < end && nums[start] == nums[start - 1]) {
            start++;
          }
          while (end < numCount - 1 && end > start && nums[end] == nums[end + 1]) {
            end--;
          }
        }
      }
    }

    return resultList;
  }
}
