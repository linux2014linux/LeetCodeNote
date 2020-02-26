package Java.Solution.S0300;

import java.util.Arrays;

public class S0300 {

  public int lengthOfLIS(int[] nums) {
//    return forceRecursive(nums, Integer.MIN_VALUE, 0);
//    return forceRecursiveWithMemo(nums);
//    return dp(nums);
    return dpWithBinarySearch(nums);
  }

  /**
   * 暴力求解, 找到<<<以当前元素向前的所有递增子序列长度>>>, 最后返回最大的长度, 构造递归函数解决
   * 以当前元素为结尾的最大长度, 该长度的队列可能包含该元素, 也可能不包含该元素!!!
   * 这里的思路和实现有些迷惑之处, 我们要以当前元素开始的所有递增子序列的最大长度, 但递归实际上是
   * 从以当前元素结束的最大子序列长度依次递归计算
   * 时间 2^N, 递归树最底层元素的数量, 空间 N 递归数的深度
   * @param nums 数组
   * @param prev 当前元素之前的递增子序列的最后一个元素
   * @param curPos 当前元素的索引
   * @return
   */
  public int forceRecursive(int[] nums, int prev, int curPos) {
    if (nums.length == curPos) {
      return 0;
    }

    int lenOfIncludeCur = 0;
    if (nums[curPos] > prev) {
      lenOfIncludeCur = 1 + forceRecursive(nums, nums[curPos], curPos + 1);
    }
    /**
     *  8,9,100,11,12,13 解释为什么还需要求解不包含当前元素的长度
     *  子序列为 8,9 时, prev=9, curPos = 2
     *  1 + forceRecursive(nums, 100, 3)
     *  forceRecursive(nums, 9, 3)
     *  显然对于上述序列, 最终不包含 100 这个元素的子序列时最大的
     */
    int lenOfExcludeCur = forceRecursive(nums, prev, curPos + 1);
    return Math.max(lenOfIncludeCur, lenOfExcludeCur);
  }

  /**
   * 带记忆的暴力递归解法
   * memos[i][j]表示以nums[i]为前一个元素,nums[j]为当前元素的子序列的长度
   * 在无记忆的递归程序中,以num[j+1]结尾的所有子序列要将以num[j+1]结尾时的子序列长度重新计算
   * memos旨在将其计算过的长度保存避免重复计算, 从而降低递归树的高度
   * 时间 N^2, 空间 N^2
   */
  public int forceRecursiveWithMemo(int[] nums) {
    int memo[][] = new int[nums.length + 1][nums.length];
    for (int[] l : memo) {
      Arrays.fill(l, -1);
    }
    return forceRecursiveWithMemo(nums, -1, 0, memo);
  }
  public int forceRecursiveWithMemo(int[] nums, int prevIndex, int curPos, int[][] memos) {
    if (curPos == nums.length) {
      return 0;
    }

    if (memos[prevIndex + 1][curPos] >= 0) {
      return memos[prevIndex + 1][curPos];
    }

    int lenOfIncludeCur = 0;
    if (prevIndex < 0 || nums[prevIndex] < nums[curPos]) {
      lenOfIncludeCur = 1 + forceRecursiveWithMemo(nums, curPos, curPos + 1, memos);
    }
    int lenOfExcludeCur = forceRecursiveWithMemo(nums, prevIndex, curPos + 1, memos);
    memos[prevIndex + 1][curPos] = Math.max(lenOfIncludeCur, lenOfExcludeCur);
    return memos[prevIndex + 1][curPos];
  }

  /**
   * 动态规划
   * 一开始想法是动态规划, 第i个元素结尾的最大长度为l[i] = max(l[i - 1] + 1, l[i - 1])
   * 外层i = 0; i < len; 内层j = 0; j < len; 动态规划没错但思路是错误的, 此处错误在于不应该是i-1,应该是i
   * 的前驱元素索引, 如 1,2,1,6 i=3时, 不应该时i=2, 而应该是 i=1, 即6的前驱元素是2, 而不是1
   * 参考评论区后重新思考, 应当为外层i = 0; i < len; 内层j = 0; j < i;
   * 动态方程为 dp[i] = Math.max(dp[i], dp[j] + 1)
   * 具体意思是 以当前元素为末尾元素, 寻找前面有多少个小于末尾元素的 因为子序列长度是逐个加长的, dp在变化
   * 的过程中保证了动态方程始终有效
   * 一开始担心 1 2 1 6这种情况, 实际上 dp[3] = Math.max(dp[3], dp[2] + 1), 在j = 2时 dp[j] = 1
   * 而 dp[3] 已经是 3 了, 因此不会受影响
   * 时间 N^2, 空间 N
   * @param nums
   * @return
   */
  public int dp(int[] nums) {
    int len = nums.length;
    if (len < 1) {
      return 0;
    }

    int maxLen = 1;
    int[] dp = new int[len];
    Arrays.fill(dp, 1); // 每个元素自己就是一个长度为1的子序列
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1); // 在包含nums[j]和不包含nums[j]的长度中取较大的一个
        }
      }
      maxLen = Math.max(maxLen, dp[i]);
    }

    return maxLen;
  }

  /**
   * 带有二分搜索的动态规划思想, 思路清奇, 真不好想到
   * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-she-ji-fang-fa-zhi-pai-you-xi-jia/
   * 该链接利用纸牌游戏分堆的方法详细解释了该算法的原理, 非常清晰
   * 时间 N * log(N), 空间 N
   * @param nums
   * @return
   */
  public int dpWithBinarySearch(int[] nums) {
    int maxLen = 0;
    if (nums.length < 1) {
      return maxLen;
    }

    /**
     * dp 并非最长递增子序列, 但最终的长度却是最常子序列的长度
     */
    int[] dp = new int[nums.length];
    for (int num : nums) {
      /**
       * 二分查找
       * 当元素在数组中时, 返回该元素的插入点
       * 当元素不在数组中, 并且元素小于数组元素最小值, 返回-1
       * 当元素不在数据中, 并且元素大于数组元素最大值, 返回-(len + 1)
       * 当元素不在数组中, 但在数组元素的范围内, 返回插入点位置的负数, 从1开始计数;
       */
      int insertPoint = Arrays.binarySearch(dp, 0, maxLen, num);
      if (insertPoint < 0) {
        insertPoint = -(insertPoint + 1);
      }
      dp[insertPoint] = num;
      if (insertPoint == maxLen) { // 当前元素使得最常子序列的长度增加
        maxLen++;
      }
    }
    return maxLen;
  }
}
