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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot == null)
            return true;

        if(root == null)
            return false;

        if(isSameTree(root, subRoot)) // current root pe check karo
            return true; // if it return true good
        else
        {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        }
        // tricky part
        // but if is doesnt root ke left and right part se compare 
        
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot)
    {
        if(root == null && subRoot == null)
            return true;

        if(root == null || subRoot == null)
            return false;

        if(root.val != subRoot.val)
            return false;
            
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

}
