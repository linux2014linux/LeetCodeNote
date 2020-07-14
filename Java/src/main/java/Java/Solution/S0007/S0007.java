package Java.Solution.S0007;

public class S0007 {

  public int reverse(int x) {
    return way2(x);
  }

  // 笨方法, 转换成字符串处理
  public int way1(int x) {

    char[] chs = String.format("%d", x).toCharArray();
    int length = chs.length;
    for (int i = 0; i < length / 2; i++) {
      int j = length - 1 - i;

      char temp = chs[i];
      chs[i] = chs[j];
      chs[j] = temp;
    }

    String rs = String.valueOf(chs);
    if (chs[length - 1] == '-') {
      rs = '-' + rs.substring(0, length - 1);
    }

    long s = Long.parseLong(rs);
    if (s >= Integer.MIN_VALUE && s <= Integer.MAX_VALUE) {
      return (int)s;
    }

    return 0;
  }

  // 数学方法
  public int way2(int x) {
    int r = 0;
    while (x != 0) {
      int num = x % 10;

      // num > 7, 是2^31 - 1的数量
      if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE && num > Integer.MAX_VALUE % 10)) {
        return 0;
      }

      // num = -8, 是-2^31的数量
      if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE && num < Integer.MIN_VALUE % 10)) {
        return 0;
      }
      r = r * 10 + num;
      x = x / 10;
    }
    return r;
  }
}
