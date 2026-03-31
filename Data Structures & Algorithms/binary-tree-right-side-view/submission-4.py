# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return result
        result.append(root.val) # initial root added
        queue = deque([root])

        while queue:
            size = len(queue)
            rightmost = None # put None here
            for i in range(size):
                node = queue.popleft()
                if node.left:
                    rightmost = node.left # its node.left or node.right . Next row basically
                    queue.append(node.left)
                if node.right:
                    rightmost = node.right
                    queue.append(node.right)
        
            if rightmost: # if there is a right
                result.append(rightmost.val) # then append

        return result
        