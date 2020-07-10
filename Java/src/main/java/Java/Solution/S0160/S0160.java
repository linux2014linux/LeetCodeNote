package Java.Solution.S0160;

public class S0160 {

  class ListNode {

    int val;
    ListNode next;

    public ListNode(int x) {
      val = x;
      next = null;
    }
  }

  /**
   * a + c + b = b + c + a
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    if (headA == null || headB == null) {
      return null;
    }

    ListNode p1 = headA, p2 = headB;
    while (p1 != p2) {
      p1 = p1 == null ? headB : p1.next;
      p2 = p2 == null ? headA : p2.next;
    }
    return p1;
  }
}
