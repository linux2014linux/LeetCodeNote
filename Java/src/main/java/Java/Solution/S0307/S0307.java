package Java.Solution.S0307;

public class S0307 {
  private int segTree[];
  private int n;

  public S0307(int[] nums) {
    n = nums.length;
    if (n > 0) {
      segTree = new int[4 * n];
      buildSegTree(nums, 0, n - 1, 0);
    }
  }

  public void update(int i, int val) {
    updateSegTreeNode(i, val, 0, n - 1, 0);
  }

  public int sumRange(int i, int j) {
    return getRangeSum(i, j, 0, n - 1, 0);
  }

  private void buildSegTree(int[] nums, int start, int end, int idx) {
    if (start == end) {
      segTree[idx] = nums[start];
      return;
    }

    int mid = (start + end) / 2;
    buildSegTree(nums, start, mid, idx * 2 + 1);
    buildSegTree(nums, mid + 1, end, idx * 2 + 2);
    segTree[idx] = segTree[idx * 2 + 1] + segTree[idx * 2 + 2];
  }

  private void updateSegTreeNode(int i, int val, int start, int end, int idx) {
    if (start == end) {
      segTree[idx] = val;
      return;
    }

    int mid = (start + end) / 2;
    if (i <= mid) {
      updateSegTreeNode(i, val, start, mid, idx * 2 + 1);
    } else {
      updateSegTreeNode(i, val, mid + 1, end, idx * 2 + 2);
    }
    segTree[idx] = segTree[idx * 2 + 1] + segTree[idx * 2 + 2];
  }

  private int getRangeSum(int i, int j, int start, int end, int idx) {
    if (i > end || j < start) {
      return 0;
    }
    if (i <= start && j >= end) {
      return segTree[idx];
    }

    int mid = (start + end) / 2;
    int leftSum = getRangeSum(i, j, start, mid, idx * 2 + 1);
    int rightSum = getRangeSum(i, j, mid + 1, end, idx * 2 + 2);
    return leftSum + rightSum;
  }
}
