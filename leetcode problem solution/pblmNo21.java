//21. Merge Two Sorted Lists
public class pblmNo21 {
   // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode mergeHead;
        ListNode tail;

        // Decide the first node
        if (list1.val <= list2.val) {
            mergeHead = list1;
            list1 = list1.next;
        } else {
            mergeHead = list2;
            list2 = list2.next;
        }

        tail = mergeHead;

        // Merge remaining nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;

        return mergeHead;
    }
}
