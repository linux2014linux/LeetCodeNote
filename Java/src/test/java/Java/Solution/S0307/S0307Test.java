package Java.Solution.S0307;

import org.junit.Assert;
import org.junit.Test;

public class S0307Test {
  @Test
  public void test() {
    int[] nums = {1, 3, 5};
    S0307 s0307 = new S0307(nums);

    Assert.assertTrue(s0307.sumRange(0, 2) == 9);
    s0307.update(1, 2);
    Assert.assertTrue(s0307.sumRange(0, 2) == 8);
  }
}
