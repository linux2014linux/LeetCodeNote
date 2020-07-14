package Java.Solution.S0007;

import org.junit.Assert;
import org.junit.Test;

public class S0007Test {

  @Test
  public void test1() {
    S0007 s0007 = new S0007();
    Assert.assertTrue(s0007.reverse(123) == 321);
    Assert.assertTrue(s0007.reverse(-123) == -321);
    Assert.assertTrue(s0007.reverse(120) == 21);
  }
}
