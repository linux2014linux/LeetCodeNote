package Java.Solution.S0009;

public class S0009 {

  //  转换为字符串处理
  public boolean isPalindrome(int x) {
    String s = String.format("%d", x);
    boolean r = true;
    for (int i = 0; i < s.length() / 2; i++) {
      r &= (s.charAt(i) == s.charAt(s.length() - i - 1));
      if (!r) {
        break;
      }
    }
    return r;
  }

  // 通过数学方法取出前后两个数字
  public boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }

    // 类似于求取x的长度
    int div = 1;
    while (x / div >= 10) {
      div *= 10;
    }

    while (x > 0) {
      int left = x / div;
      int right = x % 10;
      if (left != right) {
        return false;
      }

      x = (x % div) / 10;
      div /= 100;
    }
    return true;
  }

  // 在0的基础上用后半段数字计算出一个数字和原始数字的前半段相等即可
  // 123454321 -> 12345
  // 54321 0 -> 12345
  public boolean isPalindrome3(int x) {
    // 最高位不为0, 因此末尾为0直接返回
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }
    return x == revertedNumber || x == revertedNumber / 10;
  }
}
