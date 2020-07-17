package Java.Solution.S0023;

import Java.Solution.S0023.S0023.ListNode;
import org.junit.Test;

public class S0023Test {

  @Test
  public void test1() {
    S0023 s0023 = new S0023();
    ListNode a1 = s0023.buildList(new int[]{1, 3, 5});
    ListNode b1 = s0023.buildList(new int[]{2, 4});
    ListNode r = s0023.merge(a1, b1);
    s0023.printList(r);
  }

  @Test
  public void test2() {
    S0023 s0023 = new S0023();
    ListNode a1 = s0023.buildList(new int[]{1, 3});
    ListNode b1 = s0023.buildList(new int[]{2});
    ListNode c1 = s0023.buildList(new int[]{5, 9});

    ListNode[] ls = {a1, b1, c1};
    ListNode r = s0023.kMerge(ls, 0, ls.length - 1);
    s0023.printList(r);
  }

  @Test
  public void test3() {
    S0023 s0023 = new S0023();
    ListNode a1 = s0023.buildList(new int[]{-10, -9, -9, -3, -1, -1, 0});
    ListNode b1 = s0023.buildList(new int[]{-5});
    ListNode c1 = s0023.buildList(new int[]{4});
    ListNode d1 = s0023.buildList(new int[]{-8});
    ListNode e1 = s0023.buildList(new int[]{-9, -6, -5, -4, -2, 2, 3});
    ListNode f1 = s0023.buildList(new int[]{-3, -3, -2, -1, 0});
    ListNode[] ls = {a1, b1, c1, d1, e1, f1};
    ListNode r = s0023.kMerge(ls, 0, ls.length - 1);
    s0023.printList(r);
  }
}
