package Java.Solution.S0118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S0118 {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows < 1) {
      return result;
    }
    for (int row = 0; row < numRows; row++) {
      int lenOfRow = row + 1;
      List<Integer> numsOfRow = Arrays.asList(new Integer[lenOfRow]);
      numsOfRow.set(0, 1);
      numsOfRow.set(row, 1);
      for (int col = 1; col < row; col++) {
        List<Integer> numsOfPrevRow = result.get(row - 1);
        numsOfRow.set(col, numsOfPrevRow.get(col) + numsOfPrevRow.get(col - 1));
      }
      result.add(numsOfRow);
    }
    return result;
  }
}
