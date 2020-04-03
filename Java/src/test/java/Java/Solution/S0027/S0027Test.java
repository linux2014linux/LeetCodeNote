package Java.Solution.S0027;

import org.junit.Assert;
import org.junit.Test;

public class S0027Test {

  @Test
  public void test() {
    S0027 s0027 = new S0027();
    int nums1[] = {3, 2, 2, 3};
    int val = 3;
    int size = s0027.removeElement(nums1, 3);
    Assert.assertTrue(size == 2);

    int nums2[] = {};
    val = 3;
    size = s0027.removeElement(nums2, val);
    Assert.assertTrue(size == 0);

    int nums3[] = {0, 1, 2, 2, 3, 0, 4, 2};
    val = 2;
    size = s0027.removeElement(nums3, val);
    Assert.assertTrue(size == 5);
  }
}
