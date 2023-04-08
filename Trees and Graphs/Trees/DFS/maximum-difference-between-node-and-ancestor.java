
/**
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
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
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return 0;
        }
        return helper(root,root.val,root.val);
    }
    public int helper(TreeNode node, int min,int max){
        if(node==null){
            return Math.abs(min-max);
        }
        if(node.val<min){
            min = node.val;
        }
        if(node.val>max){
            max = node.val;
        }
        return Math.max(helper(node.left,min,max),helper(node.right,min,max));
    }
}
