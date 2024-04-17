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
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    // public boolean helper(TreeNode node,Integer l, Integer h){
    //     if(node==null) return true;
    //     if((l!=null&&node.val<=l)||(h!=null&&node.val>=h)) return false;
    //     boolean left = helper(node.left,l,node.val);
    //     boolean right = helper(node.right,node.val,h);
    //     return left&&right;
    // }
    public boolean helper(TreeNode curr, Integer max, Integer min){
        if(curr==null) return true;
        boolean check = true;
        if(max!=null) check = check && curr.val<max;
        if(min!=null) check = check && curr.val>min;
        return check && helper(curr.left,curr.val,min) && helper(curr.right,max,curr.val);
    }
}