package Java.Solution.S0023;

public class S0023 {

  public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int num) {
      this.val = num;
    }
  }

  public ListNode buildList(int[] nums) {
    if (nums == null || nums.length < 1) {
      return null;
    }

    ListNode temp = new ListNode();
    ListNode h = temp;
    for (int num : nums) {
      temp.next = new ListNode(num);
      temp = temp.next;
    }
    return h.next;
  }

  public void printList(ListNode list) {
    while (list != null) {
      System.out.print(String.format("%d ", list.val));
      list = list.next;
    }
  }

  public ListNode merge(ListNode l1, ListNode l2) {

    ListNode temp = new ListNode();
    ListNode h = temp;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        temp.next = l1;
        l1 = l1.next;
      } else {
        temp.next = l2;
        l2 = l2.next;
      }
      temp = temp.next;
    }
    temp.next = l1 != null ? l1 : l2;

    return h.next;
  }

  public ListNode kMerge(ListNode[] ls, int i, int j) {
    if (ls == null || ls.length == 0) {
      return null;
    }

    int mid = (j + i) / 2;
    if (j - i > 1) {
      ListNode left = kMerge(ls, i, mid);
      ListNode right = kMerge(ls, mid+1, j);
      return merge(left, right);
    } else if (j - i == 1) {
      return merge(ls[i], ls[j]);
    } else {
      return ls[j];
    }
  }
}
