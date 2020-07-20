package Java.Solution.S0006;

import org.junit.Assert;
import org.junit.Test;

public class S0006Test {

  @Test
  public void test1() {
    S0006 s0006 = new S0006();
    String s = "LEETCODEISHIRING";
    String e = "LCIRETOESIIGEDHN";
    int numRows = 3;
    String t = s0006.convert(s, numRows);
    Assert.assertTrue(e.equals(t));

    s = "LEETCODEISHIRING";
    e = "LDREOEIIECIHNTSG";
    numRows = 4;
    t = s0006.convert(s, numRows);
    Assert.assertTrue(e.equals(t));

    s = "AB";
    e = "AB";
    numRows = 1;
    t = s0006.convert(s, numRows);
    Assert.assertTrue(e.equals(t));
  }
}
