package Java.Solution.S0390;

public class S0390 {

  /**
   * 此题目一开始想用双向链表解决, 翻阅评论区域发现有规律, 最终参考如下连接理解并解答
   https://leetcode-cn.com/problems/elimination-game/solution/gui-lu-de-xun-zhao-by-luo-ben-zhu-xiao-man-tou/
   其他解答方案基本都是这个思路, 不过有的按照递归方式实现而已

   思路: 无论从哪一侧开始删除, 我们只需要重新定位当前的第一个元素即可
   核心逻辑即确定每次删除后，剩下数字的第一个元素应当是哪个
   */
  public int lastRemaining(int n) {
    if (n == 0) {
      return 0;
    }

    int start = 1, step = 1, length = n;
    boolean isLeft = true;
    while (length != 1) {
      if (isLeft || (length & 1) != 0) { // 从左侧开始或者右侧开始总数量为奇数个, 起始位置都是向左移动一个步长
        start = start + step;
      }
      isLeft = !isLeft; // 方向切换
      length = length >> 1; // 长度变化
      step = step << 1; // 步长变化(步长用于求第一个开始的数)
    }

    return start;
  }

  /**
   这个解法是评论区一个大佬给出的, 其博客也给出了详细的规律探索过程
   https://blog.csdn.net/afei__/article/details/83689502
   */
  public int lastRemaining1(int n) {
    return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
  }
}
