/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        
        
        int count = goodnode(root, root.val);

        return count;
        

        
    }

    public int goodnode(TreeNode node, int value)
    {
        if(node == null)
            return 0;
        if(node.val >= value)
            return 1 + goodnode(node.left, node.val) + goodnode(node.right, node.val);
        else
            return goodnode(node.left, value) + goodnode(node.right, value);

    }


}
