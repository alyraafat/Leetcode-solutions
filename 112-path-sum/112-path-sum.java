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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return helper(root,targetSum,0);
    }
    public boolean helper(TreeNode node, int targetSum, int acc){
        if(node==null) return false;
        if(node.left==null&&node.right==null){
            if(acc+node.val==targetSum) return true;
            else return false;
        }
        boolean left = helper(node.left,targetSum,acc+node.val);
        boolean right = helper(node.right,targetSum,acc+node.val);
        return left||right;
    } 
}