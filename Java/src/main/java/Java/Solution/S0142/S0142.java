package Java.Solution.S0142;

public class S0142 {

  class ListNode {

    int val;
    ListNode next;

    public ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode head) {

    boolean haveCycle = false;
    ListNode p1 = head, p2 = head;
    while (p2 != null) {
      p1 = p1.next;

      p2 = p2.next;
      if (p2 != null) {
        p2 = p2.next;
      }

      if (p1 == p2 && p1 != null) {
        haveCycle = true;
        break;
      }
    }

    ListNode cyclyEntryNode = null;
    if (haveCycle) {
      p2 = head;
      while (p1 != p2) {
        p1 = p1.next;
        p2 = p2.next;
      }
      cyclyEntryNode = p1;
    }
    return cyclyEntryNode;
  }
}
