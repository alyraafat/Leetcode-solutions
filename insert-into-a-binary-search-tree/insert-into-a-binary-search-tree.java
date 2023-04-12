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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        return helper(root,new TreeNode(val),root, root,true);
        
    }
    public TreeNode helper(TreeNode node, TreeNode val, TreeNode root,TreeNode prev, boolean left){
        if(node==null){
            if(left){
                prev.left = val;
            }else {
                prev.right = val;
            }
            return root;
        }
        if(node.val<val.val){
            return helper(node.right,val,root,node,false);
        }else {
            return helper(node.left,val,root,node,true);
        }
        
    }
}