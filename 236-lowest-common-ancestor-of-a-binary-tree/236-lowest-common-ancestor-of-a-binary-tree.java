/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        TreeNode ans = helper(root,p,q); 
        return ans==null?root:ans;
    }
    public TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        if(node==null) return null;
        TreeNode left = helper(node.left,p,q);
        TreeNode right = helper(node.right,p,q);
        if(node==p&&(left==q||right==q)) return p;
        if(node==q&&(left==p||right==p)) return q;
        if((left==p&&right==q)||left==q&&right==p) return node;
        if((left==null&&right!=null)||(left!=null&&right==null))
            return left==null?right:left;
        if(node==p) return p;
        if(node==q) return q;
        return null;
    }
}