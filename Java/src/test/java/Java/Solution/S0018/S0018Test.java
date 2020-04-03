package Java.Solution.S0018;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class S0018Test {

  @Test
  public void test() {
    int[] nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    Map<String, Integer> expectedResultMap = new HashMap<String, Integer>() {{
      put("-1001", 1);
      put("-2-112", 1);
      put("-2002", 1);
    }};
    diffExpectAndOutput(nums, target, expectedResultMap);
  }

  @Test
  public void test1() {
    int[] nums = {0, 0, 0, 0};
    int target = 0;
    Map<String, Integer> expectedResultMap = new HashMap<String, Integer>() {{
      put("0000", 1);
    }};
    diffExpectAndOutput(nums, target, expectedResultMap);
  }

  @Test
  public void test2() {
    int[] nums = {1,-2,-5,-4,-3,3,3,5};
    int target = -11;
    Map<String, Integer> expectedResultMap = new HashMap<String, Integer>() {{
      put("-5-4-31", 1);
    }};
    diffExpectAndOutput(nums, target, expectedResultMap);
  }

  public String intListToSortedString(List<Integer> numList) {
    StringBuilder stringBuilder = new StringBuilder();
    Collections.sort(numList);
    for (int num : numList) {
      stringBuilder.append(num);
    }
    return stringBuilder.toString();
  }

  public void diffExpectAndOutput(int[] nums, int target, Map<String, Integer> expectedResultMap) {
    S0018 s0018 = new S0018();
    List<List<Integer>> listList = s0018.fourSum(nums, target);
    if (listList.size() != expectedResultMap.size()) {
      Assert.assertTrue(false);
    }
    for (List<Integer> list : listList) {
      String key = intListToSortedString(list);
      Assert.assertTrue(expectedResultMap.containsKey(key) && expectedResultMap.get(key) == 1);
      expectedResultMap.put(key, expectedResultMap.get(key) + 1);
    }
  }
}
