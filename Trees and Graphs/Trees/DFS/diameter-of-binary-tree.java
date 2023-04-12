/**
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
**/



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
       
        return Math.max(helper(node.left,Math.max(2+left+right,maxSoFar)),helper(node.right,Math.max(2+left+right,maxSoFar)));
    }
    
}
