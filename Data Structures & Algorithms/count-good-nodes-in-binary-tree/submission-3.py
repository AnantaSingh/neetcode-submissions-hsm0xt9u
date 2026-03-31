# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:

        def good(node, maxValue):
            if not node:
                return 0

            if node.val >= maxValue:
                return 1 + good(node.left, max(maxValue, node.val)) + good(node.right, max(maxValue, node.val))
            else:
                return good(node.left, max(maxValue, node.val)) + good(node.right, max(maxValue, node.val))

        return good(root, root.val) 
        