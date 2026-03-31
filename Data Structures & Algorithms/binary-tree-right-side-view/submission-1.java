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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> answer = new ArrayList<>();
        if(root == null)
            return answer;
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        stack.push(root);
        queue.add(root);

        while(!queue.isEmpty())
        {  
            int size = queue.size();
            TreeNode rightMost = null;
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);

                rightMost = node;
   
            }
            answer.add(rightMost.val);

        }

        return answer;

        
    }
}
