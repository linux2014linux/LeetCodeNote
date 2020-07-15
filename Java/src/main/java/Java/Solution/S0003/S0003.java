package Java.Solution.S0003;

// 滑动窗口思想
public class S0003 {

  public int lengthOfLongestSubstring(String s) {
    if (s == null) {
      return 0;
    }

    int[] positionMap = new int[256];
    for (int i = 0; i < 256; i++) {
      positionMap[i] = -1;
    }

    int maxLength = 0, windowStartIndex = 0;
    for (int sIndex = 0; sIndex < s.length(); sIndex++) {
      // pos时字符的整数形式
      int pos = (int)s.charAt(sIndex);

      // windowsStartIndex变大即出现重复字符,窗口起始位置向左移动
      windowStartIndex = Math.max(windowStartIndex, positionMap[pos] + 1);

      maxLength = Math.max(maxLength, sIndex - windowStartIndex + 1);
      positionMap[pos] = sIndex;
    }

    return maxLength;
  }
}
