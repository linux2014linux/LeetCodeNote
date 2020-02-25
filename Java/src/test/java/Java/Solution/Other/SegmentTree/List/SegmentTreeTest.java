package Java.Solution.Other.SegmentTree.List;

import org.junit.Assert;
import org.junit.Test;

public class SegmentTreeTest {
  @Test
  public void test() {
    SegmentTree segmentTree = new SegmentTree();
    int[] nums = {1, 3, 5};
    SegmentTreeNode root = segmentTree.build(nums);
    Assert.assertTrue(segmentTree.query(root, 0, 2) == 5);
    segmentTree.update(root, 1, 8);
    Assert.assertTrue(segmentTree.query(root, 0, 2) == 8);
  }
}
