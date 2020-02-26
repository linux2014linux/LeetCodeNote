package Java.Solution.S0850;

import org.junit.Assert;
import org.junit.Test;

public class S0850Test {

  @Test
  public void way2Test() {
    S0850 s0850 = new S0850();
    int[][] rects = {{11, 4, 22, 74}, {11, 33, 22, 85}, {28, 12, 59, 15}, {61, 38, 100, 41},
        {27, 27, 93, 93}, {18, 32, 80, 43}};
    int area = s0850.way2(rects);
    Assert.assertTrue(area == 5416);

    int[][] rects2 = {{0, 0, 1000000000, 1000000000}};
    area = s0850.way2(rects2);
    Assert.assertTrue(area == 49);

    int[][] rect3 = {{0, 0, 3, 3}, {2, 0, 5, 3}, {1, 1, 4, 4}};
    area = s0850.way2(rect3);
    Assert.assertTrue(area == 18);

    int[][] rect4 = {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
    area = s0850.way2(rect4);
    Assert.assertTrue(area == 6);
  }

  @Test
  public void way3Test() {
    S0850 s0850 = new S0850();
    int[][] rects = {{11, 4, 22, 74}, {11, 33, 22, 85}, {28, 12, 59, 15}, {61, 38, 100, 41},
        {27, 27, 93, 93}, {18, 32, 80, 43}};
    int area = s0850.way3(rects);
    Assert.assertTrue(area == 5416);

    int[][] rects2 = {{0, 0, 1000000000, 1000000000}};
    area = s0850.way3(rects2);
    Assert.assertTrue(area == 49);

    int[][] rect3 = {{0, 0, 3, 3}, {2, 0, 5, 3}, {1, 1, 4, 4}};
    area = s0850.way3(rect3);
    Assert.assertTrue(area == 18);

    int[][] rect4 = {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
    area = s0850.way3(rect4);
    Assert.assertTrue(area == 6);

    int[][] rects5 = {{5, 5, 15, 10}, {11, 8, 20, 13}};
    area = s0850.way3(rects5);
    Assert.assertTrue(area == 87);
  }

  @Test
  public void way4Test() {
    S0850 s0850 = new S0850();
    int[][] rects = {{11, 4, 22, 74}, {11, 33, 22, 85}, {28, 12, 59, 15}, {61, 38, 100, 41},
        {27, 27, 93, 93}, {18, 32, 80, 43}};
    int area = s0850.way4(rects);
    Assert.assertTrue(area == 5416);

    int[][] rects1 = {{5, 5, 15, 10}, {11, 8, 20, 13}};
    area = s0850.way4(rects1);
    Assert.assertTrue(area == 87);

    int[][] rects2 = {{0, 0, 1000000000, 1000000000}};
    area = s0850.way4(rects2);
    Assert.assertTrue(area == 49);

    int[][] rect3 = {{0, 0, 3, 3}, {2, 0, 5, 3}, {1, 1, 4, 4}};
    area = s0850.way4(rect3);
    Assert.assertTrue(area == 18);

    int[][] rect4 = {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
    area = s0850.way4(rect4);
    Assert.assertTrue(area == 6);
  }
}
