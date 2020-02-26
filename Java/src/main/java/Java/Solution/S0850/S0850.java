package Java.Solution.S0850;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 此题目解法均参考LeetCode官方题解
public class S0850 {

  public int rectangleArea(int[][] rectangles) {
    int rectCount = rectangles.length;
    if (rectCount < 1) {
      return 0;
    }

    // 构造val为最大值的线段树
    return way4(rectangles);
  }

  /**
   * 坐标压缩(离散化), 时间复杂度 O(N^3), 空间复杂度 O(N^2)
   */
  public int way2(int[][] rectangles) {
    // 找出所有x,y的坐标
    Set<Integer> xVals = new HashSet<>();
    Set<Integer> yVals = new HashSet<>();
    for (int[] rect : rectangles) {
      xVals.add(rect[0]);
      xVals.add(rect[2]);
      yVals.add(rect[1]);
      yVals.add(rect[3]);
    }

    // 排序
    Integer[] xValsSorted = xVals.toArray(new Integer[0]);
    Arrays.sort(xValsSorted);
    Integer[] yValsSorted = yVals.toArray(new Integer[0]);
    Arrays.sort(yValsSorted);

    // 坐标映射
    Map<Integer, Integer> xMapi = new HashMap<>();
    for (int i = 0; i < xValsSorted.length; i++) {
      xMapi.put(xValsSorted[i], i);
    }
    Map<Integer, Integer> yMapi = new HashMap<>();
    for (int i = 0; i < yValsSorted.length; i++) {
      yMapi.put(yValsSorted[i], i);
    }

    // 标记原始矩形在映射后包含哪些方格
    boolean[][] mapedGrids = new boolean[xValsSorted.length][yValsSorted.length];
    for (int[] rect : rectangles) {
      for (int x = xMapi.get(rect[0]); x < xMapi.get(rect[2]); x++) {
        for (int y = yMapi.get(rect[1]); y < yMapi.get(rect[3]); y++) {
          mapedGrids[x][y] = true;
        }
      }
    }

    // 根据标记好的映射后的矩阵计算总面积
    long area = 0L;
    for (int i = 0; i < mapedGrids.length; i++) {
      for (int j = 0; j < mapedGrids[0].length; j++) { // 长度都一样,因此用第一个的长度作为边界
        if (mapedGrids[i][j]) {
          area +=
              (long) (xValsSorted[i + 1] - xValsSorted[i]) * (yValsSorted[j + 1] - yValsSorted[j]);
        }
      }
    }

    area %= 1_000_000_007;
    return (int) area;
  }

  /**
   * 线性扫描, 时间复杂度 O((N^2)*log(N)), 空间复杂度 O(N)
   */
  public int way3(int[][] rectangles) {
    int i = 0;
    int in = 1, out = -1;
    int[][] yLevels = new int[rectangles.length * 2][];
    for (int[] rectangle : rectangles) {
      yLevels[i++] = new int[]{rectangle[1], in, rectangle[0], rectangle[2]}; // 进入线
      yLevels[i++] = new int[]{rectangle[3], out, rectangle[0], rectangle[2]}; // 退出线
    }
    Arrays.sort(yLevels, new Comparator<int[]>() { // x方向的区间合并必须满足从小到大排序
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
      }
    });

    long area = 0L;
    int prevY = yLevels[0][0];
    List<int[]> pendingInLevelList = new ArrayList<>(); // 待计算面积的进入线
    for (int[] yLevel : yLevels) {
      int curLevelY = yLevel[0], curLevelType = yLevel[1], curLevelX1 = yLevel[2], curLevelX2 = yLevel[3];

      // 计算面积
      long sumX = 0, pendingInLevelCurX = 0;
      for (int[] pendingInLevel : pendingInLevelList) { // sumX的计算就是区间合并问题
        pendingInLevelCurX = Math.max(pendingInLevel[0], pendingInLevelCurX);
        sumX += Math.max(pendingInLevel[1] - pendingInLevelCurX, 0); // [1,4] [2,3] 因此与0比较
        pendingInLevelCurX = Math.max(pendingInLevel[1], pendingInLevelCurX); // [1,4] [2,3]同上
      }
      area += sumX * (curLevelY - prevY);

      if (curLevelType == in) { // 进入线入未决数组
        pendingInLevelList.add(new int[]{curLevelX1, curLevelX2});
        Collections.sort(pendingInLevelList, new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[0], o2[0]);
          }
        });
      } else { // 移除退出线
        for (i = 0; i < pendingInLevelList.size(); i++) {
          if (curLevelX1 == pendingInLevelList.get(i)[0]
              && curLevelX2 == pendingInLevelList.get(i)[1]) { // 将计算过面积的当前进入线移除
            pendingInLevelList.remove(i);
            // 因为可能有不同的矩形矩形相同的退出线, 但当前只计算了一个矩形的面积, 所以不能全部移除
            // {1, 1, 3, 3}, {1, 2, 3, 3} 退出线同是[1, 3], 但当前只计算了与前者相关的面积
            break;
          }
        }
      }
      prevY = curLevelY;
    }

    area %= 1_000_000_007;
    return (int) area;
  }

  /**
   * 线性扫描+线段树, 时间复杂度O(N * logN), 空间复杂度 O(N)
   * @param rectangles
   * @return
   */
  public int way4(int[][] rectangles) {

    // 扫描线按照纵坐标递增排序
    int OPEN = 1, CLOSE = -1;
    int[][] lines = new int[rectangles.length * 2][];
    Set<Integer> Xvals = new HashSet();
    int t = 0;
    for (int[] rec : rectangles) {
      lines[t++] = new int[]{rec[1], OPEN, rec[0], rec[2]};
      lines[t++] = new int[]{rec[3], CLOSE, rec[0], rec[2]};
      Xvals.add(rec[0]);
      Xvals.add(rec[2]);
    }
    Arrays.sort(lines, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
      }
    });

    // 离散化x坐标
    Integer[] X = Xvals.toArray(new Integer[0]);
    Arrays.sort(X);
    Map<Integer, Integer> Xi = new HashMap();
    for (int i = 0; i < X.length; ++i) {
      Xi.put(X[i], i);
    }

    // 构建线段树
    SegTree segTree = new SegTree();
    SegNode root = segTree.build(0, X.length - 1, X);

    // 计算面积
    long ans = 0;
    long cur_x_sum = 0;
    int cur_y = lines[0][0];
    for (int[] line : lines) {
      int y = line[0], type = line[1], x1 = line[2], x2 = line[3];
      ans += cur_x_sum * (y - cur_y);
      segTree.update(root, Xi.get(x1), Xi.get(x2), type);
      cur_x_sum = root.len;
      cur_y = y;
    }

    ans %= 1_000_000_007;
    return (int) ans;
  }

  /**
   * 线段树的值,左右区间和pushUp方法的含义都是灵活多变的, 要根据不同的题目类型适配, 不要死死的套结构
   * 例如: 值可以是类, 包含多种信息
   * 左右区间不一定没有交集也可以是[left, mid], [mid, right]等
   * pushUp可以是求和, 可以时最大值等
   */
  class SegTree {
    public void pushUp(SegNode node) {
      if (node.count > 0) { // 是一条完整的线段
        node.len = node.X[node.end] - node.X[node.start];
        return;
      }
      if (node.end == node.start) { // 不是线段
        node.len = 0;
      } else { // 线段由左右两部分组成
        node.len = node.lc.len + node.rc.len;
      }
    }

    /**
     * 构建线段树
     * 此处的线段树区间和常规的线段树有点区别
     * 通常的线段树区间是[left, mid], [mid + 1, right], 此处时是[left, mid], [mid, right]
     * 因此构建线段树的终止条件要适当修改
     * @param start
     * @param end
     * @param X
     * @return
     */
    public SegNode build(int start, int end, Integer[] X) {
      SegNode node = new SegNode(start, end, X);
      SegNode lc, rc;
      if (start + 1 == end) {
        lc = new SegNode(start, start, X);
        rc = new SegNode(end, end, X);
      } else {
        int mid = node.getMid();
        lc = build(start, mid, X);
        rc = build(mid, end, X);
      }
      node.lc = lc;
      node.rc = rc;
      return node;
    }

    public void update(SegNode node, int x1, int x2, int lineType) {
      if (x2 <= node.start || x1 >= node.end) { // 要更新的线段与当前区间无交集
        return;
      }

      if (x1 <= node.start && x2 >= node.end) { // 要更新的线段完全覆盖当前区间
        node.count += lineType;
        pushUp(node);
        return;
      }

      int mid = node.getMid();
      if (x2 <= mid) { // 只更新左孩子
        update(node.lc, x1, x2, lineType); // 更新左孩子
      } else if (x1 > mid) { // 只更新右孩子
        update(node.rc, x1, x2, lineType); // 更新右孩子
      } else {
        update(node.lc, x1, x2, lineType); // 更新左孩子
        update(node.rc, x1, x2, lineType); // 更新右孩子
      }
      pushUp(node); // 更新父节点的值
    }
  }

  class SegNode {
    int start, end; // 起始点
    SegNode lc, rc; // 左右子树
    int count; // 被查找寻区间覆盖次数
    long len; // 区间长度
    Integer[] X; // X实际坐标

    public SegNode(int start, int end, Integer[] X) {
      this.start = start;
      this.end = end;
      this.X = X;
      lc = null;
      rc = null;
      count = 0;
      len = 0;
    }

    public int getMid() {
      return (start + end) >> 1;
    }
  }
}
