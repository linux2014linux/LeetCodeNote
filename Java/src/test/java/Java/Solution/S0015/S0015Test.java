package Java.Solution.S0015;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class S0015Test {

  @Test
  public void threeSumTest() {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    Map<String, Integer> expectedResultMap = new HashMap<String, Integer>(){{
      put("-1-12", 1);
      put("-101", 1);
    }};
    diffExpectAndOutput(nums, expectedResultMap);
  }

  @Test
  public void threeSumTest2() {
    int[] nums = {-2,-7,-11,-8,9,-7,-8,-15,10,4,3,9,8,11,1,12,-6,-14,-2,-1,-7,-13,-11,-15,11,-2,7,-4,12,7,-3,-5,7,-7,3,2,1,10,2,-12,-1,12,12,-8,9,-9,11,10,14,-6,-6,-8,-3,-2,14,-15,3,-2,-4,1,-9,8,11,5,-14,-1,14,-6,-14,2,-2,-8,-9,-13,0,7,-7,-4,2,-8,-2,11,-9,2,-13,-10,2,5,4,13,13,2,-1,10,14,-8,-14,14,2,10};
    Map<String, Integer> expectedResultMap = new HashMap<String, Integer>(){{
      put("-15114", 1);
      put("-15213", 1);
      put("-15312", 1);
      put("-15411", 1);
      put("-15510", 1);
      put("-1578", 1);
      put("-14014", 1);
      put("-14113", 1);
      put("-14212", 1);
      put("-14311", 1);
      put("-14410", 1);
      put("-1459", 1);
      put("-1477", 1);
      put("-13-114", 1);
      put("-13013", 1);
      put("-13112", 1);
      put("-13211", 1);
      put("-13310", 1);
      put("-1349", 1);
      put("-1358", 1);
      put("-12-214", 1);
      put("-12-113", 1);
      put("-12012", 1);
      put("-12111", 1);
      put("-12210", 1);
      put("-1239", 1);
      put("-1248", 1);
      put("-1257", 1);
      put("-11-314", 1);
      put("-11-213", 1);
      put("-11-112", 1);
      put("-11011", 1);
      put("-11110", 1);
      put("-1129", 1);
      put("-1138", 1);
      put("-1147", 1);
      put("-10-414", 1);
      put("-10-313", 1);
      put("-10-212", 1);
      put("-10-111", 1);
      put("-10010", 1);
      put("-1019", 1);
      put("-1028", 1);
      put("-1037", 1);
      put("-1055", 1);
      put("-9-514", 1);
      put("-9-413", 1);
      put("-9-312", 1);
      put("-9-211", 1);
      put("-9-110", 1);
      put("-909", 1);
      put("-918", 1);
      put("-927", 1);
      put("-945", 1);
      put("-8-614", 1);
      put("-8-513", 1);
      put("-8-412", 1);
      put("-8-311", 1);
      put("-8-210", 1);
      put("-8-19", 1);
      put("-808", 1);
      put("-817", 1);
      put("-835", 1);
      put("-844", 1);
      put("-7-714", 1);
      put("-7-613", 1);
      put("-7-512", 1);
      put("-7-411", 1);
      put("-7-310", 1);
      put("-7-29", 1);
      put("-7-18", 1);
      put("-707", 1);
      put("-725", 1);
      put("-734", 1);
      put("-6-612", 1);
      put("-6-511", 1);
      put("-6-410", 1);
      put("-6-39", 1);
      put("-6-28", 1);
      put("-6-17", 1);
      put("-615", 1);
      put("-624", 1);
      put("-633", 1);
      put("-5-49", 1);
      put("-5-38", 1);
      put("-5-27", 1);
      put("-505", 1);
      put("-514", 1);
      put("-523", 1);
      put("-4-48", 1);
      put("-4-37", 1);
      put("-4-15", 1);
      put("-404", 1);
      put("-413", 1);
      put("-422", 1);
      put("-3-25", 1);
      put("-3-14", 1);
      put("-303", 1);
      put("-312", 1);
      put("-2-24", 1);
      put("-2-13", 1);
      put("-202", 1);
      put("-211", 1);
      put("-1-12", 1);
      put("-101", 1);
    }};
    diffExpectAndOutput(nums, expectedResultMap);
  }

  @Test
  public void threeSumTest3() {
    int[] nums = {-2, 0, 1, 1, 2};
    Map<String, Integer> expectedResultMap = new HashMap<String, Integer>() {{
      put("-202", 1);
      put("-211", 1);
    }};
    diffExpectAndOutput(nums, expectedResultMap);
  }

  public String intListToSortedString(List<Integer> numList) {
    StringBuilder stringBuilder = new StringBuilder();
    Collections.sort(numList);
    for (int num : numList) {
      stringBuilder.append(num);
    }
    return stringBuilder.toString();
  }

  public void diffExpectAndOutput(int[] nums, Map<String, Integer> expectedResultMap) {
    S0015 s0015 = new S0015();
    List<List<Integer>> listList = s0015.threeSum(nums);
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
