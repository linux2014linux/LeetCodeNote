package Java.Solution.S0026;

import org.junit.Assert;
import org.junit.Test;

public class S0026Test {

  @Test
  public void test() {
    S0026 s0026 = new S0026();
    int nums1[] = {1, 1, 2};
    int count = s0026.removeDuplicates(nums1);
    Assert.assertTrue(count == 2);

    int nums2[] = {};
    count = s0026.removeDuplicates(nums2);
    Assert.assertTrue(count == 0);

    int nums3[] = {23};
    count = s0026.removeDuplicates(nums3);
    Assert.assertTrue(count == 1);

    int nums4[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    count = s0026.removeDuplicates(nums4);
    Assert.assertTrue(count == 5);
  }
}
