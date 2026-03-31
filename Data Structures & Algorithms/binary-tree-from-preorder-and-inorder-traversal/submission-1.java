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
    // Approach 1: Using HashMap for O(1) lookup - OPTIMAL ⭐
    // Time: O(n), Space: O(n)
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        
        // Build hashmap for O(1) inorder lookups
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int left, int right) {
        // Base case: no elements to construct tree
        if (left > right) {
            return null;
        }
        
        // Pick current root from preorder
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        
        // Find root position in inorder to split left/right subtrees
        int inorderIndex = inorderIndexMap.get(rootVal);
        
        // Build left and right subtrees
        // Left subtree: elements from left to inorderIndex-1
        // Right subtree: elements from inorderIndex+1 to right
        root.left = buildTreeHelper(preorder, left, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorderIndex + 1, right);
        
        return root;
    }
}