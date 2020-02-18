package Java.Solution.S0922;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class S0922Test {

  @Test
  public void sortArrayByParityIITest() {
    S0922 s0922 = new S0922();
    int[] testData = {4, 2, 5, 7};
    int[] resultNums = s0922.sortArrayByParityII(testData);
    StringBuilder stringBuilder = new StringBuilder();
    for (int num : resultNums) {
      stringBuilder.append(num);
    }

    Set<String> expectedResult = new HashSet<>();
    expectedResult.add("4527");
    expectedResult.add("4725");
    expectedResult.add("2547");
    expectedResult.add("2745");
    Assert.assertTrue(expectedResult.contains(stringBuilder.toString()));
  }
}
