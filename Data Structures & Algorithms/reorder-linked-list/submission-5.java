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

        // DIVIDE into 2 parts 
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;


        //reverse second half
        ListNode prev = null;
        while(second != null)
        {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        //keep both heads
        ListNode first = head;
        second = prev;
        while(second != null) // second is smaller
        {
            // store next of both heads
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            // change pointers 
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
        
    }
}
