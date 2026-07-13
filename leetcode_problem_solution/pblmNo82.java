//82. Remove Duplicates from Sorted List II
public class pblmNo82 {
    //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
     public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            // if duplicate sequence found
            if (current.next != null && current.val == current.next.val) {
                int dup = current.val;

                // skip all nodes with same value
                while (current != null && current.val == dup) {
                    current = current.next;
                }

                prev.next = current;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
    }
}
