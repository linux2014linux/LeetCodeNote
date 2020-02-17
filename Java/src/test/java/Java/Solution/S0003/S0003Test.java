package Java.Solution.S0003;

import org.junit.Assert;
import org.junit.Test;

public class S0003Test {

  @Test
  public void lengthOfLongestSubstringTest() {
    S0003 s0003 = new S0003();
    int maxLength = 0;
    String s = "";

    s = "";
    maxLength = s0003.lengthOfLongestSubstring(s);
    Assert.assertTrue(maxLength == 0);

    s = null;
    maxLength = s0003.lengthOfLongestSubstring(s);
    Assert.assertTrue(maxLength == 0);

    s = " ";
    maxLength = s0003.lengthOfLongestSubstring(s);
    Assert.assertTrue(maxLength == 1);

    s = "dvdf";
    maxLength = s0003.lengthOfLongestSubstring(s);
    Assert.assertTrue(maxLength == 3);

    s = "abcabcbb";
    maxLength = s0003.lengthOfLongestSubstring(s);
    Assert.assertTrue(maxLength == 3);

    s = "bbbbb";
    maxLength = s0003.lengthOfLongestSubstring(s);
    Assert.assertTrue(maxLength == 1);

    s = "pwwkew";
    maxLength = s0003.lengthOfLongestSubstring(s);
    Assert.assertTrue(maxLength == 3);

    s = "abba";
    maxLength = s0003.lengthOfLongestSubstring(s);
    Assert.assertTrue(maxLength == 2);

    s = "wobgrovw";
    maxLength = s0003.lengthOfLongestSubstring(s);
    Assert.assertTrue(maxLength == 6);
  }
}
