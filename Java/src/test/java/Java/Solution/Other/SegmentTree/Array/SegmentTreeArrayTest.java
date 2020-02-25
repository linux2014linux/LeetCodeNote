package Java.Solution.Other.SegmentTree.Array;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeArrayTest {

  @Test
  public void test() {
    SegmentTreeByArray segmentTreeByArray = new SegmentTreeByArray();
    int[] nums = {1, 3, 5};
    segmentTreeByArray.build(nums);
    Assert.assertTrue(segmentTreeByArray.sumRange(0, 2) == 9);
    segmentTreeByArray.update(1, 2);
    Assert.assertTrue(segmentTreeByArray.sumRange(0, 2) == 8);
  }
}
