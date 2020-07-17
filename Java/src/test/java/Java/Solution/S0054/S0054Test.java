package Java.Solution.S0054;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class S0054Test {

  @Test
  public void test1() {
    S0054 s0054 = new S0054();
    int[] a = {1, 2, 3, 6, 9, 8, 7, 4, 5};
    List<Integer> t = intsToList(a);
    List<Integer> r = s0054.spiralOrder(new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}});
    boolean ok = true;
    for (int i = 0; i < r.size(); i++) {
      ok &= (t.get(i).equals(r.get(i)));
    }
    Assert.assertTrue(ok && t.size() == r.size());
  }

  @Test
  public void test2() {
    S0054 s0054 = new S0054();
    int[] a = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
    List<Integer> t = intsToList(a);
    List<Integer> r = s0054.spiralOrder(new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}});
    boolean ok = true;
    for (int i = 0; i < r.size(); i++) {
      ok &= (t.get(i).equals(r.get(i)));
    }
    Assert.assertTrue(ok && t.size() == r.size());
  }

  private List<Integer> intsToList(int[] nums) {
    List<Integer> t = new ArrayList<>();
    for (int num : nums) {
      t.add(num);
    }
    return t;
  }
}
