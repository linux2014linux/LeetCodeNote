package Java.Solution.S0005;

import java.util.Arrays;

public class S0005 {
  public String longestPalindrome(String s) {
    return way3(s);
  }

  /**
   * 暴力方法, 找出每个子串, 依次判断是否是回文串并找出长度最大的
   * @param s
   * @return
   */
  public String way1(String s) {

    if (s == null || s.length() < 2) {
      return null;
    }

    // s.charAt每次都会检查越界, 浪费时间
    char[] chs = s.toCharArray();
    int length = s.length();
    int startOfMax = 0, maxLen = 1;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        int curLen = j - i + 1;
        if (curLen > maxLen && validate(chs, i, j)) {
          maxLen = curLen;
          startOfMax = i;
        }
      }
    }

    return s.substring(startOfMax, startOfMax + maxLen);
  }
  private boolean validate(char[] s, int start, int end) {
    while (start < end) {
      if (s[start++] != s[end--]) {
        return false;
      }
    }
    return true;
  }

  /**
   * 以每个字符作为中心点对折 时间复杂度最低, 但细节较多
   * @param s
   * @return
   */
  public String way2(String s) {
    if (s == null || s.length() < 2) {
      return null;
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

  /**
   * 动态规划
   * @param s
   * @return
   */
  public String way3(String s) {
    if (s == null || s.length() < 2) {
      return null;
    }

    char[] chs = s.toCharArray();
    int length = s.length();
    boolean[][] dp = new boolean[length][length];
    for (int i = 0; i < length; i++) {
      Arrays.fill(dp[i], false);
    }

    for (int i = 0; i < length; i++) {
      dp[i][i] = true;
    }

    int maxLen = 1;
    int startOfMax = 0;
    for (int j = 1; j < length; j++) {
      for (int i = 0; i < j; i++) {
        dp[i][j] = chs[i] == chs[j] && (j - i < 3 || dp[i + 1][j - 1]);
        if (dp[i][j]) {
          int curLen = j - i + 1;
          if (curLen > maxLen) {
            maxLen = curLen;
            startOfMax = i;
          }
        }
      }
    }

    return s.substring(startOfMax, startOfMax + maxLen);
  }
}
