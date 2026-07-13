//445. Add Two Numbers II
public class pblmNo445 {
    //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Reverse both lists
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        // Add numbers
        ListNode result = add(l1, l2);

        //  Reverse result to restore forward order
        return reverseList(result);
    }
    private ListNode add(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
