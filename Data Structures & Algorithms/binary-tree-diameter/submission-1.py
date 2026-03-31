# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        answer = 0

        def diameter(root):
            nonlocal answer # IMP int is immutable so need to do this in inner function

            if not root:
                return 0
            
            left = diameter(root.left)
            right = diameter(root.right)

            answer = max(answer, left + right) # diameter will have + , left + right

            return 1 + max(left, right) # while return add 1

        diameter(root) # remember to call it
        return answer
        

    