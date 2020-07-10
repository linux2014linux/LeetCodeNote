package Java.Solution.S0141;

import Java.Solution.S0141.S0141.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class S0141Test {

  @Test
  public void test1() {
    S0141 s0141 = new S0141();
    ListNode head = s0141.new ListNode(4);
    Assert.assertTrue(s0141.hasCycle(head) == false);
  }

  @Test
  public void test2() {
    S0141 s0141 = new S0141();
    ListNode head = null;
    Assert.assertTrue(s0141.hasCycle(head) == false);
  }

  @Test
  public void test3() {
    S0141 s0141 = new S0141();
    ListNode head = s0141.new ListNode(3);
    ListNode node1 = s0141.new ListNode(4);
    head.next = node1;
    Assert.assertTrue(s0141.hasCycle(head) == false);
  }


  @Test
  public void test4() {
    S0141 s0141 = new S0141();
    ListNode head = s0141.new ListNode(3);
    head.next = head;
    Assert.assertTrue(s0141.hasCycle(head) == true);
  }

  @Test
  public void test5() {
    S0141 s0141 = new S0141();
    ListNode head = s0141.new ListNode(3);
    ListNode node1 = s0141.new ListNode(3);
    ListNode node2 = s0141.new ListNode(3);
    ListNode node3 = s0141.new ListNode(3);
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node1;
    Assert.assertTrue(s0141.hasCycle(head) == true);
  }
}
