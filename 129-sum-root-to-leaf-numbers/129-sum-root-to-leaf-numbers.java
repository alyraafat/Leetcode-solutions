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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode node, int curr){
        if(node==null){
            return;
        }
        curr = curr*10+node.val;
        if(node.left==null&&node.right==null){
            sum+=curr;
            return;
        }
        helper(node.left,curr);
        helper(node.right,curr);   
    }
}