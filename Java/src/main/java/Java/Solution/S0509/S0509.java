package Java.Solution.S0509;

public class S0509 {
  public int fib(int N) {
    if (N == 0) {
      return 0;
    }
    if (N == 1) {
      return 1;
    }
    if (N == 2) {
      return 1;
    }

    int a = 1, b =1, sum = 0;
    for (int i = 3; i <= N; i++) {
      sum = (a + b) % 1000000007;
      a = b;
      b = sum;
    }

    return sum;
  }
}
