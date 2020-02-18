package Java.Solution.S0016;

import org.junit.Assert;
import org.junit.Test;

public class S0016Test {

  @Test
  public void threeSumClosestTest() {
    S0016 s0016 = new S0016();
    int nums[] = {-1, 2, 1, -4};
    int target = 1;
    int sumClosest = s0016.threeSumClosest(nums, target);
    Assert.assertTrue(sumClosest == 2);

    int nums2[] = {0, 2, 1, -3};
    target = 1;
    sumClosest = s0016.threeSumClosest(nums2, target);
    Assert.assertTrue(sumClosest == 0);
  }
}
