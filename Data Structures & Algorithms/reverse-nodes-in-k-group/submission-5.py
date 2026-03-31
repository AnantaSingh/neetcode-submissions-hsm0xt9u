# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        
        dummy = ListNode(0, head)
        groupPrev = dummy
        

        while True:
            Kth = groupPrev
            count = k
            while Kth and count > 0: 
                Kth = Kth.next 
                count -= 1
            
            if not Kth:
                break
    
            groupNext = Kth.next

            # reverse
            prev = groupNext
            curr = groupPrev.next

            while curr != groupNext: 
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp

            temp = groupPrev.next
            groupPrev.next = Kth
            groupPrev = temp
        
        return dummy.next



            







        