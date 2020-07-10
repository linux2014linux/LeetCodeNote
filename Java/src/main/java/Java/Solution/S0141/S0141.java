package Java.Solution.S0141;

public class S0141 {

  class ListNode {

    int val;
    ListNode next;

    public ListNode(int x) {
      val = x;
      next = null;
    }
  }

  /**
   快慢指针证明
   情景1: 如果快指针与慢指针相差1，继续走1步，则两指针相遇;
   情景2: 如果快指针与慢指针相差2，继续走1步，则两指针相差1格;
   情景3: 如果快指针与慢指针相差3，继续走1步，则两指针相差2格;
   …
   情景N: 如果快指针与慢指针相差N格，继续走1步，则两指针相差N-1格.
   相差N, 最终演变为相差1, 如果有环则必然相遇;
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {

    ListNode p1 = head, p2 = head;
    while (p2 != null) {
      p1 = p1.next;

      p2 = p2.next;
      if (p2 != null) {
        p2 = p2.next;
      }

      if (p1 == p2 && p1 != null) {
        return true;
      }
    }

    return false;
  }
}
