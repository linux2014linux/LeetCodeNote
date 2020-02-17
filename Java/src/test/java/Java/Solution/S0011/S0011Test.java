package Java.Solution.S0011;

import org.junit.Assert;
import org.junit.Test;

public class S0011Test {

  @Test
  public void maxAreaTest() {
    S0011 s0011 = new S0011();

    int[] height = {2, 3};
    int maxArea = s0011.maxArea(height);
    Assert.assertTrue(maxArea == 2);

    int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    maxArea = s0011.maxArea(height1);
    Assert.assertTrue(maxArea == 49);

    int[] height2 = {2, 3, 10, 5, 7, 8, 9};
    maxArea = s0011.maxArea(height2);
    Assert.assertTrue(maxArea == 36);
  }
}
