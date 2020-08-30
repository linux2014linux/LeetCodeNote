package Java.Solution.Other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.Assert;
import org.junit.Test;

public class MultiTreeTest {

  @Test
  public void test1() {
    MultiTree multiTree = new MultiTree();

    Map<Integer, Queue<Integer>> childValueListMap = new HashMap<>();
    childValueListMap.put(1, new LinkedList<>(Arrays.asList(new Integer[]{2, 3})));
    childValueListMap.put(2, new LinkedList<>(Arrays.asList(new Integer[]{21, 22, 23})));
    childValueListMap.put(3, new LinkedList<>(Arrays.asList(new Integer[]{31, 32})));
    childValueListMap.put(32, new LinkedList<>(Arrays.asList(new Integer[]{321, 322, 323})));
    List<Integer> exceptLevelList = Arrays.asList(new Integer[]{1, 2, 3, 21, 22, 23, 31, 32, 321, 322, 323});

    MultiTree.MyNode root = multiTree.build(1, childValueListMap);
    Assert.assertTrue(root != null);

    List<Integer> resultLevelList = multiTree.levelTraversal(root);
    Assert.assertTrue(exceptLevelList.size() == resultLevelList.size());
    for (int i  = 0; i < exceptLevelList.size(); i++) {
      Assert.assertTrue(exceptLevelList.get(i).equals(resultLevelList.get(i)));
    }
  }
}
