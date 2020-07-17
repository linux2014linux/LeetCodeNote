package Java.Solution.S0059;

public class S0059 {

  public int[][] generateMatrix(int n) {

    int end = n*n;
    int[][] r = new int[n][n];
    int num = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n-i; j++) {
        r[i][j] = ++num;
      }
      if (num >= end) {
        break;
      }

      for (int j = i+1; j < n-i; j++) {
        r[j][n-i-1] = ++num;
      }
      if (num >= end) {
        break;
      }

      for (int j = n-i-2; j>=i; j--) {
        r[n-i-1][j] = ++num;
      }
      if (num >= end) {
        break;
      }

      for (int j = n-i-2; j>i; j--) {
        r[j][i] = ++num;
      }
      if (num >= end) {
        break;
      }
    }
    return r;
  }
}
