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
    TreeNode res;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root,p);
        return res;
    }
    public boolean inorder(TreeNode root, TreeNode p){
        if(root==null) return false;
        if(root==p){
            if(root.right!=null){
                TreeNode curr = root.right;
                while(curr.left!=null){
                    curr = curr.left;
                }
                res = curr;
                return false;
            }else{
                return true;
            }
        }
        boolean isLeft = inorder(root.left,p);
        if(isLeft){
            res = root;
        }
        boolean isRight = inorder(root.right,p);
        return isRight;
    }
}