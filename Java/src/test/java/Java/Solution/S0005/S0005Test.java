package Java.Solution.S0005;

import org.junit.Test;

public class S0005Test {

  @Test
  public void longestPalindromeTest() {
    S0005 s0005 = new S0005();
    String input = null;
    String output = null;

    output = s0005.longestPalindrome(input);
    System.out.println(String.format("output:%s", output));

    input = "";
    output = s0005.longestPalindrome(input);
    System.out.println(String.format("output:%s", output));

    input = "a";
    output = s0005.longestPalindrome(input);
    System.out.println(String.format("output:%s", output));

    input = "aa";
    output = s0005.longestPalindrome(input);
    System.out.println(String.format("output:%s", output));

    input = "aaa";
    output = s0005.longestPalindrome(input);
    System.out.println(String.format("output:%s", output));

    input = "abbbaadbdaa";
    output = s0005.longestPalindrome(input);
    System.out.println(String.format("output:%s", output));

    input = "abc";
    output = s0005.longestPalindrome(input);
    System.out.println(String.format("output:%s", output));

    input = "aba";
    output = s0005.longestPalindrome(input);
    System.out.println(String.format("output:%s", output));

    input = "abcbadabc";
    output = s0005.longestPalindrome(input);
    System.out.println(String.format("output:%s", output));
  }
}
