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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        return helper(root,0);
    }
    public int maxLength(TreeNode node){
        if(node==null){
            return -1;
        }
        
        return 1+Math.max(maxLength(node.left),maxLength(node.right));
    }
    public int helper(TreeNode node, int maxSoFar){
        if(node==null||(node.left==null&&node.right==null)){
            return maxSoFar;
        }
        
        int left = maxLength(node.left);  
        int right = maxLength(node.right);
        
        // if(left==0){
        //     return helper(node.right,Math.max(1+right,maxSoFar));
        // }
        // if(right==0){
        //     return helper(node.left,Math.max(1+left,maxSoFar));
        // }
        return Math.max(helper(node.left,Math.max(2+left+right,maxSoFar)),helper(node.right,Math.max(2+left+right,maxSoFar)));
    }
    
}