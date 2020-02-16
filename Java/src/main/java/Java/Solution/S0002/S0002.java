package Java.Solution.S0002;

public class S0002 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode cursor = head;

    int val1 = 0, val2 = 0, sum = 0, carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      val1 = l1 != null ? l1.val : 0;
      val2 = l2 != null ? l2.val : 0;
      sum = val1 + val2 + carry;
      carry = sum / 10;

      ListNode curNode = new ListNode(sum % 10);
      cursor.next = curNode;
      cursor = curNode;

      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
    }

    return head.next;
  }
}
