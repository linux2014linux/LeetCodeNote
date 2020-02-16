package Java.Solution.S0002;

import org.junit.Assert;
import org.junit.Test;

public class S0002Test {

  public ListNode buildNumList(int [] vals) {
    ListNode head = new ListNode(0), cursor = head;
    for (int val : vals) {
      ListNode node = new ListNode(val);
      cursor.next = node;
      cursor = node;
    }
    return head.next;
  }

  @Test
  public void addTwoNumbersTest1() {
    S0002 s0002 = new S0002();
    int[] vals1 = {2, 4, 3};
    ListNode l1 = buildNumList(vals1);
    int[] vals2 = {5, 6, 4};
    ListNode l2 = buildNumList(vals2);
    ListNode lSum = s0002.addTwoNumbers(l1, l2);
    int[] vSum = {7, 0, 8};
    int i = 0;
    while (lSum != null) {
      Assert.assertTrue(vSum[i++] == lSum.val);
      lSum = lSum.next;
    }
  }

  @Test
  public void addTwoNumbersTest3() {
    S0002 s0002 = new S0002();
    int[] vals1 = {0};
    ListNode l1 = buildNumList(vals1);
    int[] vals2 = {5, 6, 4};
    ListNode l2 = buildNumList(vals2);
    ListNode lSum = s0002.addTwoNumbers(l1, l2);
    int[] vSum = {5, 6, 4};
    int i = 0;
    while (lSum != null) {
      Assert.assertTrue(vSum[i++] == lSum.val);
      lSum = lSum.next;
    }

    lSum = s0002.addTwoNumbers(l2, l1);
    i = 0;
    while (lSum != null) {
      Assert.assertTrue(vSum[i++] == lSum.val);
      lSum = lSum.next;
    }

    lSum = s0002.addTwoNumbers(null, l2);
    i = 0;
    while (lSum != null) {
      Assert.assertTrue(vSum[i++] == lSum.val);
      lSum = lSum.next;
    }
  }

  @Test
  public void addTwoNumbersTest4() {
    S0002 s0002 = new S0002();
    int[] vals1 = {2};
    ListNode l1 = buildNumList(vals1);
    int[] vals2 = {8, 9, 9};
    ListNode l2 = buildNumList(vals2);
    ListNode lSum = s0002.addTwoNumbers(l1, l2);
    int[] vSum = {0, 0, 0, 1};
    int i = 0;
    while (lSum != null) {
      Assert.assertTrue(vSum[i++] == lSum.val);
      lSum = lSum.next;
    }
  }
}
