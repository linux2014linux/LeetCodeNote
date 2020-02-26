package Java.Solution.S0056;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class S0056Test {

  @Test
  public void test1() {
    S0056 s0056 = new S0056();
    int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int [][] output = s0056.merge(input);
    Map<Integer, Integer> expect = new HashMap<>();
    expect.put(1, 6);
    expect.put(8, 10);
    expect.put(15, 18);
    int validCount = customEqual(expect, output);
    Assert.assertTrue(validCount == output.length);
  }

  @Test
  public void test2() {
    S0056 s0056 = new S0056();
    int[][] input = {{1, 4}, {4, 5}};
    int[][] output = s0056.merge(input);
    Map<Integer, Integer> expect = new HashMap<>();
    expect.put(1, 5);
    int validCount = customEqual(expect, output);
    Assert.assertTrue(validCount == output.length);
  }

  @Test
  public void test3() {
    S0056 s0056 = new S0056();
    int[][] input = {{}};
    int[][] output = s0056.merge(input);
    Assert.assertTrue(output.length == 1);
  }

  @Test
  public void test4() {
    S0056 s0056 = new S0056();
    int[][] input = {{1, 4}, {2, 3}};
    int[][] output = s0056.merge(input);
    Map<Integer, Integer> expect = new HashMap<>();
    expect.put(1, 4);
    int validCount = customEqual(expect, output);
    Assert.assertTrue(validCount == output.length);
  }

  @Test
  public void test5() {
    S0056 s0056 = new S0056();
    int[][] input = {{1, 4}, {1, 4}};
    int[][] output = s0056.merge(input);
    Map<Integer, Integer> expect = new HashMap<>();
    expect.put(1, 4);
    int validCount = customEqual(expect, output);
    Assert.assertTrue(validCount == output.length);
  }
 
  @Test
  public void test6() {
    S0056 s0056 = new S0056();
    int[][] input = {{362,367},{314,315},{133,138},{434,443},{202,203},{144,145},{229,235},{205,212},{314,323},{128,129},{413,414},{342,345},{43,49},{333,342},{173,178},{386,391},{131,133},{157,163},{187,190},{186,186},{17,19},{63,69},{70,79},{386,391},{98,102},{236,239},{195,195},{338,338},{169,170},{151,153},{409,416},{377,377},{90,96},{156,165},{182,186},{371,372},{228,233},{297,306},{56,61},{184,190},{401,403},{221,228},{203,212},{39,43},{83,84},{66,68},{80,83},{32,32},{182,182},{300,306},{235,238},{267,272},{458,464},{114,120},{452,452},{372,375},{275,280},{302,302},{5,9},{54,62},{237,237},{432,439},{415,421},{340,347},{356,358},{165,168},{15,17},{259,265},{201,204},{192,197},{376,383},{210,211},{362,367},{481,488},{59,64},{307,315},{155,164},{465,467},{55,60},{20,24},{297,304},{207,210},{322,328},{139,142},{192,195},{28,36},{100,108},{71,76},{103,105},{34,38},{439,441},{162,168},{433,433},{368,369},{137,137},{105,112},{278,280},{452,452},{131,132},{475,480},{126,129},{95,104},{93,99},{394,403},{70,78}};
    Map<Integer, Integer> expect = new HashMap<>();
    expect.put(5,9);
    expect.put(15,19);
    expect.put(20,24);
    expect.put(28,38);
    expect.put(39,49);
    expect.put(54,69);
    expect.put(70,79);
    expect.put(80,84);
    expect.put(90,112);
    expect.put(114,120);
    expect.put(126,129);
    expect.put(131,138);
    expect.put(139,142);
    expect.put(144,145);
    expect.put(151,153);
    expect.put(155,168);
    expect.put(169,170);
    expect.put(173,178);
    expect.put(182,190);
    expect.put(192,197);
    expect.put(201,212);
    expect.put(221,239);
    expect.put(259,265);
    expect.put(267,272);
    expect.put(275,280);
    expect.put(297,306);
    expect.put(307,328);
    expect.put(333,347);
    expect.put(356,358);
    expect.put(362,367);
    expect.put(368,369);
    expect.put(371,375);
    expect.put(376,383);
    expect.put(386,391);
    expect.put(394,403);
    expect.put(409,421);
    expect.put(432,443);
    expect.put(452,452);
    expect.put(458,464);
    expect.put(465,467);
    expect.put(475,480);
    expect.put(481,488);
    int[][] output = s0056.merge(input);
    int validCount = customEqual(expect, output);
    Assert.assertTrue(validCount == output.length);
  }

  private int customEqual(Map<Integer, Integer> expect, int[][] output) {
    int validCount = 0;
    for (int[] item : output) {
      if (expect.containsKey(item[0]) && item[1] == expect.get(item[0])) {
        validCount++;
      }
    }
    return validCount;
  }
}