# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#   preorder = [1,2,3,4], inorder = [2,1,3,4]

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        map = {val : idx for idx, val in enumerate(inorder)}
        self.i = 0

        def dfs(l , r):
            if l > r:
                return None
            
            rootValue = preorder[self.i]
            self.i += 1
            root = TreeNode(rootValue)
            mid = map.get(rootValue)
            root.left = dfs(l , mid -1)
            root.right = dfs( mid + 1, r)
            return root
            
        return dfs(0, len(inorder) - 1)
        