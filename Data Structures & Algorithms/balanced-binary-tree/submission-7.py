# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def isbalance(root):
            if not root:
                return [True, 0]

            left = isbalance(root.left)
            right = isbalance(root.right)

            if left[0] and right[0] and abs(left[1] - right[1]) <= 1: # remember to take [1]
                return [True,  max(left[1], right[1]) + 1]
            else:
                return [False,  max(left[1], right[1]) + 1] # here max + 1 

        return isbalance(root)[0]
        