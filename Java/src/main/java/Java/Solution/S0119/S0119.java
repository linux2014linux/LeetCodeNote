package Java.Solution.S0119;

import java.util.LinkedList;
import java.util.List;

public class S0119 {
  /**
   * 杨辉三角每一个数字为组合数，第N行的数字依次时C(0, N), C(1, N), ...., C(N, N)
   */
  public List<Integer> getRow(int rowIndex) {
    List<Integer> result = new LinkedList<>();
    result.add(1);
    long prev = 1;
    for (int i = 1; i <= rowIndex; i++) {
      long cur = prev * (rowIndex - i + 1) / i;
      result.add((int)cur);
      prev = cur;
    }
    return result;
  }
}
