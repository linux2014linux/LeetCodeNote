package Java.Solution.S0054;

import java.util.ArrayList;
import java.util.List;

public class S0054 {

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> r = new ArrayList<>();

    int rCount = matrix.length;
    for (int i = 0; i < rCount-i; i++) {
      int cCount = matrix[i].length;

      // 向右
      for (int j = i; j < cCount-i; j++) {
        r.add(matrix[i][j]);
      }
      if (r.size() == rCount*cCount) {
        break;
      }

      // 向下
      for (int j = i+1; j < rCount-i; j++) {
        r.add(matrix[j][cCount-i-1]);
      }
      if (r.size() == rCount*cCount) {
        break;
      }

      // 向左
      for (int j = cCount-i-2; j >= i; j--) {
        r.add(matrix[rCount-i-1][j]);
      }
      if (r.size() == rCount*cCount) {
        break;
      }

      // 向上
      for (int j = rCount-i-2; j>i; j--) {
        r.add(matrix[j][i]);
      }
      if (r.size() == rCount*cCount) {
        break;
      }
    }

    return r;
  }
}
