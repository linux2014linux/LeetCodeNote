package Java.Solution.S0059;

import org.junit.Assert;
import org.junit.Test;

public class S0059Test {

  @Test
  public void test1() {
    S0059 s0059 = new S0059();
    int[][] t = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
    int n = 3;
    int[][] r = s0059.generateMatrix(n);
    boolean ok = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (t[i][j] == r[i][j]) {
          continue;
        } else {
          ok = false;
        }
      }
    }
    Assert.assertTrue(ok);
  }
}
