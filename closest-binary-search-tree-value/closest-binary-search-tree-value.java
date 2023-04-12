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
    public int closestValue(TreeNode root, double target) {
        if(root==null){
            return 0;
        }
        return helper(root,target,Math.abs(root.val-target),root);
    }
    public int helper(TreeNode node, double target, double minSoFar, TreeNode closest){
        if(node==null){
            return closest.val;
        }
        double diff = Math.abs(node.val-target);
        if(diff<minSoFar){
            minSoFar = diff;
            closest = node;
        }else if(diff==minSoFar){
            if(closest.val>node.val){
                closest=node;
            } 
        }
        int left = helper(node.left,target,minSoFar,closest);
        int right = helper(node.right,target,minSoFar,closest);
        double leftDiff = Math.abs(left-target);
        double rightDiff = Math.abs(right-target);
        if(leftDiff<rightDiff){
            return left;
        }else if (leftDiff>rightDiff) {
            return right;
        }else {
            return Math.min(left,right);
        }
    }
}