package Java.Solution.S0242;

import org.junit.Assert;
import org.junit.Test;

public class S0242Test {

  @Test
  public void test1() {
    String s = "";
    String t = "";
    S0242 s0242 = new S0242();
    Assert.assertTrue(s0242.isAnagram(s, t));
  }

  @Test
  public void test2() {
    String s = null;
    String t = null;
    S0242 s0242 = new S0242();
    Assert.assertFalse(s0242.isAnagram(s, t));
  }

  @Test
  public void test3() {
    String s = "anagram", t = "nagaram";
    S0242 s0242 = new S0242();
    Assert.assertTrue(s0242.isAnagram(s, t));
  }

  @Test
  public void test4() {
    String s = "rat", t = "car";
    S0242 s0242 = new S0242();
    Assert.assertFalse(s0242.isAnagram(s, t));
  }
}
