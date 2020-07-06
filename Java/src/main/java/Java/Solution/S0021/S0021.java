package Java.Solution.S0021;

public class S0021 {

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode p = new ListNode();
    ListNode h = p;
    ListNode n1 = l1;
    ListNode n2 = l2;
    while (n1 != null && n2 != null) {
      if (n1.val < n2.val) {
        p.next = n1;
        n1 = n1.next;
      } else {
        p.next = n2;
        n2 = n2.next;
      }
      p = p.next;
    }
    p.next = n1 != null ? n1 : n2;
    return h.next;
  }
}
