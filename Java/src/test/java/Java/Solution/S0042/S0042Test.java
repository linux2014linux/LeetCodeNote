package Java.Solution.S0042;

import org.junit.Assert;
import org.junit.Test;

public class S0042Test {
  @Test
  public void maxSubArray() {
    S0042 s0042 = new S0042();
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxSum = s0042.maxSubArray(nums);
    Assert.assertTrue(maxSum == 6);
  }
}
