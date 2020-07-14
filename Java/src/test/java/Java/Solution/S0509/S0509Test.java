package Java.Solution.S0509;

import org.junit.Assert;
import org.junit.Test;

public class S0509Test {
  @Test
  public void test() {
    S0509 s0509 = new S0509();
    Assert.assertTrue(s0509.fib(0) == 0);
    Assert.assertTrue(s0509.fib(1) == 1);
    Assert.assertTrue(s0509.fib(2) == 1);
    Assert.assertTrue(s0509.fib(3) == 2);
    Assert.assertTrue(s0509.fib(4) == 3);
    Assert.assertTrue(s0509.fib(5) == 5);
  }
}
