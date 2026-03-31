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
    public void reorderList(ListNode head) {

        ListNode nextHead = null;
        ListNode tail = null;
        ListNode prevTail = null;

        while(head.next != null)
        {
            if(head.next.next == null)
            {
                return;
            }
            tail = head;
            while(tail.next != null)
            {
                prevTail = tail;
                tail = tail.next;
            }

            prevTail.next = null;
                 
            nextHead = head.next;
            head.next = tail;
            tail.next = nextHead;
            head = nextHead;
        }

    }
}
