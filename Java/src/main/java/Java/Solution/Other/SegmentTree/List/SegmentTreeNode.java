package Java.Solution.Other.SegmentTree.List;

public class SegmentTreeNode {
  public int start; // 区间起点
  public int end; // 区间终点
  public int val; // 内容
  public SegmentTreeNode left; // 左孩子
  public SegmentTreeNode right; // 右孩子

  public SegmentTreeNode() {
  }

  public SegmentTreeNode(int start, int end, int val) {
    this.start = start;
    this.end = end;
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
