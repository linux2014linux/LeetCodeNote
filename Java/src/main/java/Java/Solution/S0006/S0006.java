package Java.Solution.S0006;

public class S0006 {

  public String convert(String s, int numRows) {
    if (s == null) {
      return null;
    } else if (s.length() < 1) {
      return "";
    }

    int length = s.length();
    char[] chs = s.toCharArray();
    int row = 0, col = 0, count = 0, colNum = length;
    char[][] chArr = new char[numRows][colNum];
    while (count < length) {
      // 向下
      for (row = 0; row < numRows && count < length; row++) {
        chArr[row][col] = chs[count++];
      }

      // 右上
      for (row = row - 2; row > 0 && count < length; row--) {
        chArr[row][++col] = chs[count++];
      }
      col++;
    }

    StringBuilder r = new StringBuilder();
    for (int i = 0; i < numRows && count > 0; i++) {
      for (int j = 0; j < length && count > 0; j++) {
        char ch = chArr[i][j];
        if (ch != 0) {
          r.append(chArr[i][j]);
          count--;
        }
      }
    }
    return r.toString();
  }
}
