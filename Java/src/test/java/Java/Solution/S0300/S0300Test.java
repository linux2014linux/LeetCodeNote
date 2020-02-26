package Java.Solution.S0300;

import org.junit.Assert;
import org.junit.Test;

public class S0300Test {

  @Test
  public void test() {
    S0300 s0300 = new S0300();
    int[] input1 = {};
    int count = s0300.lengthOfLIS(input1);
    Assert.assertTrue(count == 0);

    int[] input2 = {1, 3, 5, 4, 7};
    count = s0300.lengthOfLIS(input2);
    Assert.assertTrue(count == 4);

    int[] input3 = {2, 2, 2, 2, 2};
    count = s0300.lengthOfLIS(input3);
    Assert.assertTrue(count == 1);

    int[] input4 = {10, 9, 2, 5, 3, 7, 101, 18};
    count = s0300.lengthOfLIS(input4);
    Assert.assertTrue(count == 4);

    int[] input5 = {4, 10, 4, 3, 8, 9};
    count = s0300.lengthOfLIS(input5);
    Assert.assertTrue(count == 3);

    int[] input6 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
    count = s0300.lengthOfLIS(input6);
    Assert.assertTrue(count == 6);

    int[] input7 = {10, 9, 2, 5, 3, 4};
    count = s0300.lengthOfLIS(input7);
    Assert.assertTrue(count == 3);

    int[] input8 = {2, 15, 3, 7, 8, 6, 18};
    count = s0300.lengthOfLIS(input8);
    Assert.assertTrue(count == 5);
  }
}
