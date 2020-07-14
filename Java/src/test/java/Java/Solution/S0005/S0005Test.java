package Java.Solution.S0005;

import org.junit.Assert;
import org.junit.Test;

public class S0005Test {

  @Test
  public void longestPalindromeTest() {
    S0005 s0005 = new S0005();
    String input = null;
    String output = null;

    output = s0005.longestPalindrome(input);
    Assert.assertTrue(output == null);

    input = "";
    output = s0005.longestPalindrome(input);
    Assert.assertTrue(output == null);

    input = "aa";
    output = s0005.longestPalindrome(input);
    Assert.assertTrue("aa".equals(output));

    input = "aaa";
    output = s0005.longestPalindrome(input);
    Assert.assertTrue("aaa".equals(output));

    input = "abbbaadbdaa";
    output = s0005.longestPalindrome(input);
    Assert.assertTrue("aadbdaa".equals(output));

    input = "abc";
    output = s0005.longestPalindrome(input);
    Assert.assertTrue("a".equals(output) || "b".equals(output) || "c".equals(output));

    input = "aba";
    output = s0005.longestPalindrome(input);
    Assert.assertTrue("aba".equals(output));

    input = "abcbadabc";
    output = s0005.longestPalindrome(input);
    Assert.assertTrue("cbadabc".equals(output));
  }
}
