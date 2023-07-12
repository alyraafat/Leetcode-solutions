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
    int acc = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode node){
        if(node==null) return;
        helper(node.right);
        acc+=node.val;
        node.val = acc;
        helper(node.left);
    }
}