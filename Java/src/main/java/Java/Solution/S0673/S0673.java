package Java.Solution.S0673;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.util.Pair;

public class S0673 {

  /**
   * 线段树思路1 https://www.cnblogs.com/TnT2333333/p/7109977.html
   */
  public int findNumberOfLIS(int[] nums) {
    int len = nums.length;
    if (len < 1) {
      return 0;
    }

    // 将原始数字映射到从1开始的连续整数区间内
    List<Pair<Integer, Integer>> numPosPairList = new ArrayList<>();
    for (int i = 1; i <= len; i++) {
      numPosPairList.add(new Pair<>(i, nums[i - 1]));
    }

    /**
     * 因为是找递增序列, 所以按照val递增排序. TODO 为什么相同val要按索引降序
     */
    Collections.sort(numPosPairList, new Comparator<Pair<Integer, Integer>>() {
      @Override
      public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        if (o1.getValue() > o2.getValue()) {
          return 1;
        } else if (o1.getValue() == o2.getValue()) {
          if (o1.getKey() < o2.getKey()) {
            return 1;
          } else {
            return -1;
          }
        } else {
          return -1;
        }
      }
    });

    // 构建线段树
    Tree tree = new Tree();
    TreeNode root = tree.build(1, len);

    /**
     * 1. 先找以i结尾的结点, 此时i还未加入子序列中
     * 2. 修改i结点的len和count, 此时i加入子序列中(已经递增排序, 所以每次长度需要+1)
     */
    for (Pair<Integer, Integer> numPosPair : numPosPairList) {
      Value val = tree.query(root, 1, numPosPair.getKey());
      tree.update(root, numPosPair.getKey(), val.length + 1, Math.max(1, val.count));
//      tree.print(root);
//      System.out.println("\n");
    }

    return root.val.count;
  }

  /**
   * 线段树思路2 参考 https://www.cnblogs.com/keyboarder-zsq/p/6216770.html 用[0,i-1]来更新[0,i]的值
   * 将无序结构顺序化, 按照区间思路处理, 再按原始顺序更新区间内容
   */
  public int findNumberOfLIS2(int[] nums) {
    int len = nums.length;
    if (len < 1) {
      return 0;
    }

    // 排序numList
    List<Integer> numList = new ArrayList<>();
    for (int i = 1; i <= len; i++) {
      numList.add(nums[i - 1]);
    }
    Collections.sort(numList, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });

    // 将num与排序后的位置一一匹配
    List<Integer> numPosList = new ArrayList<>();
    for (int num : nums) {
      int pos = numList.indexOf(num);
      numPosList.add(pos + 1);
    }

    // 构建线段树
    Tree2 tree2 = new Tree2();
    TreeNode root = tree2.build(0, len);

    // 按照下标更新, 即就是保证递增的顺序
    for (int pos : numPosList) {
      // 查询[0, pos-1]的值
      Value val = tree2.query(root, 0, pos - 1);
      // 更新pos的值
      tree2.update(root, pos, val.length + 1, Math.max(1, val.count));
//      tree2.print(root);
//      System.out.println("\n");
    }

    return root.val.count;
  }

  /**
   * 动态规划 一开始始终没有想明白l[j] >= l[i]和l[i] + 1 == l[j]的含义 最后参考https://www.cnblogs.com/NiBosS/p/12080716.html才想明白
   * 当nums[j] > nums[i]时, l[j]和l[i]的关系无非3种 a. l[i] > l[j] 即以nums[j]结尾存在更长的长度, 此时长度+1, 数量为c[i]
   *
   * b. l[i] == l[j] {..., nums[i]}.len = l[i], {..., nums[i - 1], nums[j]}.len = l[j] => {...,
   * nums[i - 1], nums[i], nums[j]}.len = l[i] + 1, c[j] = c[i]
   *
   * c. l[i] < l[j], 特指l[i] + 1 == l[j] 以nums[i]之前的元素中存在比nums[i]大的元素才会出现此类情况, 比如[5,6,9,3,4,7]
   * 在[5,6,7]时, l[5] = 3, c[5] = 1. 当i = 3时, l[3] = 1, c[3] = 1, l[5] = 3, c[5] = 1,
   * 因为l[3]和l[5]的长度差大于1, 即l[3]是更小的长度, 因此不会影响l[j]和c[j], 因此只考虑+1的情况. i = 4时, l[4] = 2, c[4] = 1, l[5]
   * = l[4] + 1, 长度差仅为1, 此时加上nums[j]刚好时长度相同的情况
   *
   * ab两种场景可归类为存在更大长度的递增序列 c场景是存在相同长度的子序列
   */
  public int dp(int[] nums) {
    int n = nums.length;
    if (n < 1) {
      return 0;
    }
    int maxLen = 1;
    int[] lengths = new int[n];
    int[] counts = new int[n];
    Arrays.fill(lengths, 1);
    Arrays.fill(counts, 1);
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < j; i++) {
        if (nums[i] < nums[j]) { // 存在更长的长度
          if (lengths[i] >= lengths[j]) {
            lengths[j] = lengths[i] + 1;
            counts[j] = counts[i];
          } else if (lengths[i] + 1 == lengths[j]) { // 存在相同的长度
            counts[j] += counts[i];
          }
        }
      }
      maxLen = Math.max(maxLen, lengths[j]);
    }

    int countOfMaxLen = 0;
    for (int i = 0; i < lengths.length; i++) {
      if (lengths[i] == maxLen) {
        countOfMaxLen += counts[i];
      }
    }

    return countOfMaxLen;
  }

  class Tree {

    private void pushUp(TreeNode p) {
      TreeNode lc = p.lc, rc = p.rc;
      p.val.length = Math.max(lc.val.length, rc.val.length);
      if (lc.val.length == rc.val.length) {
        p.val.count = lc.val.count + rc.val.count;
      } else if (lc.val.length > rc.val.length) {
        p.val.count = lc.val.count;
      } else {
        p.val.count = rc.val.count;
      }
    }

    private TreeNode build(int start, int end) {
      TreeNode node = new TreeNode(start, end);
      if (start == end) {
        return node;
      }
      int mid = node.getMid();
      TreeNode lc = build(start, mid);
      TreeNode rc = build(mid + 1, end);
      node.lc = lc;
      node.rc = rc;
      pushUp(node);
      return node;
    }

    private Value query(TreeNode p, int l, int r) {
      if (p.start == l && p.end == r) {
        return p.val;
      }
      int mid = p.getMid();
      if (l > mid) { // 所查区间全部落在右侧
        return query(p.rc, l, r);
      } else if (r <= mid) { // 所查区间全部落在左侧
        return query(p.lc, l, r);
      } else { // 所查区间在左右两侧各有一部分
        Value lv = query(p.lc, l, mid);
        Value rv = query(p.rc, mid + 1, r);
        Value v = new Value(0, 0);
        if (lv.length > rv.length) {
          v.length = lv.length;
          v.count = lv.count;
        } else if (lv.length < rv.length) {
          v.length = rv.length;
          v.count = rv.count;
        } else {
          v.length = lv.length;
          v.count = lv.count + rv.count;
        }
        return v;
      }
    }

    public void update(TreeNode p, int i, int length, int count) {
      if (p.start == p.end && p.start == i) {
        p.val.length = length;
        p.val.count = count;
        return;
      }

      int mid = p.getMid();
      if (i <= mid) { // 所需更新的结点在左侧
        update(p.lc, i, length, count);
      } else { // 所需更新的结点在右侧
        update(p.rc, i, length, count);
      }
      pushUp(p);
    }

    private void print(TreeNode p) {
      System.out.println(String.format("start=%d, end=%d, max=%d, count=%d",
          p.start, p.end, p.val.length, p.val.count));
      if (p.start == p.end) {
        return;
      }
      print(p.lc);
      print(p.rc);
    }
  }

  class Tree2 {

    private void pushUp(TreeNode p) {
      TreeNode lc = p.lc, rc = p.rc;
      p.val.length = Math.max(lc.val.length, rc.val.length);
      if (lc.val.length == rc.val.length) {
        p.val.count = lc.val.count + rc.val.count;
      } else if (lc.val.length > rc.val.length) {
        p.val.count = lc.val.count;
      } else {
        p.val.count = rc.val.count;
      }
    }

    private TreeNode build(int start, int end) {
      TreeNode node = new TreeNode(start, end);
      if (start == end) {
        return node;
      }
      int mid = node.getMid();
      TreeNode lc = build(start, mid);
      TreeNode rc = build(mid + 1, end);
      node.lc = lc;
      node.rc = rc;
      return node;
    }

    private Value query(TreeNode p, int l, int r) {
//      System.out.println(String.format("%d,%d", l, r));
      if (p.start == l && p.end == r) {
        return p.val;
      }
      int mid = p.getMid();
      if (l > mid) { // 所查区间全部落在右侧
        return query(p.rc, l, r);
      } else if (r <= mid) { // 所查区间全部落在左侧
        return query(p.lc, l, r);
      } else { // 所查区间在左右两侧各有一部分
        Value lv = query(p.lc, l, mid);
        Value rv = query(p.rc, mid + 1, r);
        Value v = new Value(0, 0);
        if (lv.length > rv.length) {
          v.length = lv.length;
          v.count = lv.count;
        } else if (lv.length < rv.length) {
          v.length = rv.length;
          v.count = rv.count;
        } else {
          v.length = lv.length;
          v.count = lv.count + rv.count;
        }
        return v;
      }
    }

    public void update(TreeNode p, int i, int length, int count) {
      if (p.start == p.end && p.start == i) {
        if (length > p.val.length) {
          p.val.length = length;
          p.val.count = count;
        } else if (length == p.val.length) {
          p.val.count = p.val.count + count;
        }
        return;
      }

      int mid = p.getMid();
      if (i <= mid) { // 所需更新的结点在左侧
        update(p.lc, i, length, count);
      } else { // 所需更新的结点在右侧
        update(p.rc, i, length, count);
      }
      pushUp(p);
    }

    private void print(TreeNode p) {
      System.out.println(String.format("start=%d, end=%d, max=%d, count=%d",
          p.start, p.end, p.val.length, p.val.count));
      if (p.start == p.end) {
        return;
      }
      print(p.lc);
      print(p.rc);
    }
  }

  class TreeNode {

    int start, end;
    TreeNode lc, rc;
    Value val;

    public TreeNode(int start, int end) {
      this.start = start;
      this.end = end;
      this.lc = null;
      this.rc = null;
      this.val = new Value(0, 0);
    }

    public int getMid() {
      return (start + end) >> 1;
    }

    public TreeNode getLeft() {
      if (lc == null) {
        lc = new TreeNode(start, getMid());
      }
      return lc;
    }

    public TreeNode getRight() {
      if (rc == null) {
        rc = new TreeNode(getMid() + 1, end);
      }
      return rc;
    }
  }

  class Value {

    int length;
    int count;

    public Value(int len, int ct) {
      length = len;
      count = ct;
    }
  }
}
