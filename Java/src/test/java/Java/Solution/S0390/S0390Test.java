package Java.Solution.S0390;

import org.junit.Assert;
import org.junit.Test;

public class S0390Test {
  @Test
  public void lastRemainingTest() {
    S0390 s0390 = new S0390();
    int n = 9;
    int remain = s0390.lastRemaining(n);
    Assert.assertTrue(remain == 6);
  }
}
