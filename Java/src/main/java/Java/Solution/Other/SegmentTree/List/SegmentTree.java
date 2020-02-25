package Java.Solution.Other.SegmentTree.List;

public class SegmentTree {

  // 构建线段树
  public SegmentTreeNode build(int[] nums) {
    return buildHelper(0, nums.length - 1, nums);
  }

  // 更新index结点的值
  public void update(SegmentTreeNode root, int index, int val) {
    if (root.start == index && root.end == index) {
      root.val = val;
      return;
    }

    int mid = (root.start + root.end) / 2;
    if (mid >= index) {
      update(root.left, index, val);
      root.val = Math.max(root.left.val, root.right.val);
    } else {
      update(root.right, index, val);
      root.val = Math.max(root.right.val, root.right.val);
    }
  }

  // 查询[start, end]之间的最大val值
  public int query(SegmentTreeNode root, int start, int end) {
    if (start <= root.start && end >= root.end) { // 结点区间包含在搜索的区间内
      return root.val;
    }

    int mid = (root.start + root.end) / 2;
    int max = Integer.MIN_VALUE;
    if (start <= mid) { // 待求区间和左侧有交集
      max = Math.max(max, query(root.left, start, end));
    }
    if (end >= mid + 1) { // 待求区间和右侧有交集
      max = Math.max(max, query(root.right, start, end));
    }
    return max;
  }

  public SegmentTreeNode buildHelper(int rangeStart, int rangeEnd, int[] nums) {
    if (rangeStart > rangeEnd) {
      return null;
    }

    SegmentTreeNode root = new SegmentTreeNode(rangeStart, rangeEnd, nums[rangeStart]);
    if (rangeStart == rangeEnd) {
      return root;
    }

    int mid = (rangeStart + rangeEnd) / 2;
    root.left = buildHelper(rangeStart, mid, nums);
    root.right = buildHelper(mid + 1, rangeEnd, nums);
    root.val = Math.max(root.left.val, root.right.val);
    return root;
  }
}
