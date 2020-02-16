package Java.Solution.S0005;

public class S0005 {
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    int allLength = s.length();
    int left, right, keyLength;
    int maxMidPos = 0, maxLength = 1, direction = 0;
    for (int idx = 0; idx < allLength; idx++) {
      // 以当前字符对折
      keyLength = 1;
      left = idx - 1;
      right = idx + 1;
      while (left > -1 && right < allLength) {
        if (s.charAt(left) == s.charAt(right)) {
          left--;
          right++;
          keyLength += 2;
        } else {
          break;
        }
      }
      if (keyLength > maxLength) {
        maxLength = keyLength;
        maxMidPos = idx;
        direction = 0;
      }

      // 以当前字符右侧位置对折
      keyLength = 0;
      left = idx;
      right = idx + 1;
      while (left > -1 && right < allLength) {
        if (s.charAt(left) == s.charAt(right)) {
          left--;
          right++;
          keyLength += 2;
        } else {
          break;
        }
      }
      if (keyLength > maxLength) {
        maxLength = keyLength;
        maxMidPos = idx;
        direction = 1;
      }
    }

    int halfLength;
    if (direction == 0) { // 以当前字符对折
      halfLength = (maxLength - 1) / 2;
      return s.substring(maxMidPos - halfLength, maxMidPos + halfLength + 1);
    } else {
      halfLength = maxLength / 2;
      return s.substring(maxMidPos - halfLength + 1, maxMidPos + halfLength + 1);
    }
  }
}
