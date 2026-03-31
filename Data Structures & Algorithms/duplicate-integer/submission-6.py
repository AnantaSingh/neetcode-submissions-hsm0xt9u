class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        visit = set()

        for n in nums:
            if n in visit:
                return True;
            visit.add(n)

        return False

        # ordereddict
        # dequeue - stack and queue
        # list, set, dictionary, defaultdict(main)
        # heap - list (heapify), heap operations,min(default), max --
        # stack - list or dequeue
        # queue  - dequeue
        # string immutable slicing
        # array not existing
        # list  vector
        # character 
        # dont use loop when appending 2 lists, use extend
        # w3 schools, magic functions, + 2 objects , __init
        # tree, heap - list
        # graph , linkedlist - class Node, object, 2 attributes, val and next pointer(Node)
        

         