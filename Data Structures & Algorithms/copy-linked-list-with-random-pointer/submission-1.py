"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        oldToNew = {None: None} # importantxc
        h = head

        while h:
            node = Node(h.val, None, None)
            oldToNew[h] = node
            h = h.next
        
        # both Nodes

        h = head
        while h:
            copy = oldToNew[h]
            copy.next = oldToNew[h.next]
            copy.random = oldToNew[h.random]
            h = h.next

        return oldToNew[head]

        

        