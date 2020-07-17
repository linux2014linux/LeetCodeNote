package Java.Solution.Other.Probability;

/**
 * 问题描述 冰箱1有30瓶可乐, 冰箱2有31瓶可乐, 每天随机从1或者2中拿出1瓶可乐, 那么60天后冰箱2剩余1瓶可乐的概率是多少?
 *
 * 解题思路 设P(n, x1, x2) 表示第n天, 冰箱1剩余x1瓶可乐, 冰箱2剩余x2瓶可乐 则有 P(0, 30, 31) = 1, 第0天什么都没取 P(n, x1, x2) x1 ==
 * 0, P(n, 0, x2) = P(n-1, 0, x2 + 1) + 1/2 * P(n-1, 1, x2) x2 == 0, P(n, x1, 0) = P(n-1, x1+1, 0) +
 * 1/2 * P(n-1, x1, 1) x1 != 0 && x2 != 0, P(n, x1, x2) = 1/2 * P(n-1, x1+1, x2) + 1/2 * P(n-1, x1,
 * x2+1)
 *
 * 原问题为P(60, 0, 1) = ? P(60, 0, 1) = P(59, 0, 2) + 1/2 * P(59, 1, 1) ... P(2, 0, 1) = P(1, 0, 2) +
 * 1/2 * P(1, 1, 1) P(1, 0, 2) = 1/2 P(1, 1, 1) = 1/2
 *
 * 显然是一个递归, 递归的终止条件 n > 0时继续递归 n == 0时, 我们判断a和b中各自的剩余数量与初始数量的关系即可
 *
 * if (n == 0) { return a == x1 && b == x2 ? 1 : 0; } else { // 3种分支条件 }
 */
public class P1 {

  // 最原始的递归方法
  public double s1(int a, int b) {
    return p(a + b - 1, a, b, 0, 1);
  }

  public double s2(int a, int b) {

    // dp[i][j] 表示剩余从a中拿了i, b中拿了j, 且最后1个是从b里面拿的概率
    double[][] dp = new double[a+1][b+1];

    // 从a中没有取, 一直都从b中取, 所以dp[0][j]=1
    dp[0][0] = 0;
    for (int j = 1; j < b+1; j++) {
      dp[0][j] = 1;
    }

    for (int i = 1; i <= a; i++) {
      for (int j = 1; j <= b; j++) {
        dp[i][j] = 0.5 * dp[i][j-1] + 0.5 * dp[i-1][j];
      }
    }

    return dp[a][b];
  }

  private double p(int n, int a, int b, int la, int lb) {
    if (n == 0) {
      return a == la && b == lb ? 1 : 0;
    }

    if (la == 0) {
      return p(n - 1, a, b, 0, lb + 1) + 0.5 * p(n - 1, a, b, 1, lb);
    }
    if (lb == 0) {
      return p(n - 1, a, b, la + 1, 0) + 0.5 * p(n - 1, a, b, la, 1);
    }

    // a>0, b>0
    return 0.5 * p(n - 1, a, b, la + 1, lb) + 0.5 * p(n - 1, a, b, la, lb + 1);
  }
}
