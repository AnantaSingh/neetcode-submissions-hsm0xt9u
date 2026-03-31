# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxPath = float('-inf')

        def dfs(node):
            if not node:
                return 0
            leftValue = max(0, dfs(node.left))
            rightValue = max(0, dfs(node.right))
            self.maxPath = max(self.maxPath, leftValue + rightValue + node.val)
            # print(self.maxPath)
            return node.val + max(leftValue, rightValue)

        dfs(root)
        return self.maxPath
        