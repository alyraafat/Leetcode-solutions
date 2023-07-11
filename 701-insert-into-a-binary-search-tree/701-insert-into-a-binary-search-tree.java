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
        TreeNode curr=root;
        TreeNode ins = new TreeNode(val);
        if(root==null) return ins;
        TreeNode prev = null;
        boolean left = false;
        while(curr!=null){
            prev=curr;
            if(val<curr.val){
                curr=curr.left;
                left=true;
            }else{
                curr=curr.right;
                left=false;
            }
        }
        if(left) prev.left = ins;
        else prev.right=ins;
        return root;
    }
}