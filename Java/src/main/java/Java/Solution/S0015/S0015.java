package Java.Solution.S0015;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S0015 {

  public List<List<Integer>> threeSum(int[] nums) {
    int numSize = nums.length;
    List<List<Integer>> resultList = new LinkedList<>();
    Arrays.sort(nums);

    for (int i = 0; i < numSize - 2; i++) {
      if (nums[i] > 0) {
        break;
      }

      if (i > 0 && nums[i] == nums[i - 1]) { // nums[i]已经找过了,因此nums[i-1]就不用找了
        continue;
      }

      int start = i + 1, end = numSize - 1;
      while (start < end) {
        int currentSum = nums[i] + nums[start] + nums[end];
        if (currentSum == 0) {
          resultList.add(Arrays.asList(nums[i], nums[start], nums[end]));
          start++;
          end--;
          while (start < end && nums[start] == nums[start - 1]) { // 左侧相同元素跳过
            start++;
          }
          while (start < end && nums[end] == nums[end + 1]) { // 右侧相同元素跳过
            end--;
          }
        } else if (currentSum < 0) { // 和偏小
          start++;
          while (start < end && nums[start] == nums[start - 1]) { // 左侧相同元素跳过
            start++;
          }
        } else { // 和偏大
          end--;
          while (start < end && nums[end] == nums[end + 1]) { // 右侧相同元素跳过
            end--;
          }
        }
      }
    }

    return resultList;
  }
}
