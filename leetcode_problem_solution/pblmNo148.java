//148. Sort List
public class pblmNo148 {
    //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //  Split list into two halves
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;   // break list

        // Recursively sort both halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //  Merge sorted halves
        return merge(l1, l2);
    }
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }

        curr.next = (a != null) ? a : b;
        return dummy.next;
    }
}
