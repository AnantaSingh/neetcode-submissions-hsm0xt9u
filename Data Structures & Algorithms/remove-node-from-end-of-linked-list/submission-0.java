/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode reversed = reverse(head);
        int count = n-1;
        ListNode dummy = new ListNode(0);
        dummy.next = reversed;
        ListNode prev = dummy;
        ListNode head2 = reversed;

        while(count != 0)
        {
            prev = head2;
            head2 = head2.next;
            count--;
        }

        // System.out.println(prev.val);

        if(prev != null && prev.next != null)
        {
            prev.next = prev.next.next;
        }

        ListNode reversed2 = reverse(dummy.next);

        return reversed2;

    }

    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        while(head != null)
        {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }

        return prev;
    }
}
