package Java.Solution.Other.SegmentTree.Array;

public class SegmentTreeByArray {
  private int[] seg; // 线段树结构
  private int n; // 最底层元素数量

  /**
   * 根据nums构建线段树数组, 至于为什么是4倍空间参考README.md中的解释
   */
  public void build(int[] nums) {
    this.n = nums.length;
    if (this.n > 0) {
      this.seg = new int[n * 4];
      buildHelper(nums, 0, n - 1, 0);
    }
  }

  /**
   * 更新 idx 结点的值为 val
   */
  public void update(int i, int val) {
    update(0, n - 1, i, val, 0);
  }

  /**
   * 区间求和
   *
   * @param i 起始位置
   * @param j 结束位置
   */
  public int sumRange(int i, int j) {
    return sumRangeHelper(i, j, 0, n - 1, 0);
  }

  /**
   * 构建线段树
   *
   * @param nums 原始数组
   * @param start 区间起点
   * @param end 区间终点
   * @param idx 当前结点在seg中的位置
   */
  private void buildHelper(int[] nums, int start, int end, int idx) {
    if (start == end) {
      this.seg[idx] = nums[start];
      return;
    }

    int mid = (start + end) / 2;
    // 构造左子树, 当前结点在seg中的位置为idx, 因此左子树结点位置为 idx * 2 + 1, 因为idx从0开始
    buildHelper(nums, start, mid, idx * 2 + 1);
    // 构造右子树, 当前结点在seg中的位置是idx, 因此右子树的位置为 idx * 2 + 2, 因为idx从0开始
    buildHelper(nums, mid + 1, end, idx * 2 + 2);
    // 当前结点的值为左右子树的值之和
    this.seg[idx] = this.seg[idx * 2 + 1] + this.seg[idx * 2 + 2];
  }

  /**
   * 结点更新
   *
   * @param start 区间起始
   * @param end 区间结尾
   * @param i 要更新的结点的位置
   * @param val 要设置的值
   * @param idx 当前结点的位置
   */
  private void update(int start, int end, int i, int val, int idx) {
    if (start == end) {
      seg[idx] = val;
      return;
    }

    int mid = (start + end) / 2;
    if (i <= mid) { // 左子树
      update(start, mid, i, val, idx * 2 + 1);
    } else {
      update(mid + 1, end, i, val, idx * 2 + 2);
    }
    seg[idx] = seg[idx * 2 + 1] + seg[idx * 2 + 2];
  }

  /**
   * 区间求和
   */
  private int sumRangeHelper(int i, int j, int start, int end, int idx) {
    if (i > end || j < start) {
      return 0;
    }
    if (i <= start && j >= end) {
      return this.seg[idx];
    }
    int mid = (start + end) / 2;
    int leftSum = sumRangeHelper(i, j, start, mid, 2 * idx + 1); // 左边子树
    int rightSum = sumRangeHelper(i, j, mid + 1, end, 2 * idx + 2); // 右边子树
    return leftSum + rightSum;
  }
}
