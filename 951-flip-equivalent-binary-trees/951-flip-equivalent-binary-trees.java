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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return helper(root1, root2);
    }
    public boolean helper(TreeNode node1, TreeNode node2){
        if(node1==null&&node1==node2) return true;
        if((node1==null&&node2!=null)||(node1!=null&&node2==null)||node1.val!=node2.val) return false;
        
        Integer left1 = node1.left==null?null:node1.left.val;
        Integer left2 = node2.left==null?null:node2.left.val;
        Integer right1 = node1.right==null?null:node1.right.val;
        Integer right2 = node2.right==null?null:node2.right.val;
        
        if(left1==left2&&right1==right2){
            return helper(node1.left,node2.left)&&helper(node1.right,node2.right);
        }else if(left1==right2&&left2==right1){
            return helper(node1.left,node2.right)&&helper(node1.right,node2.left);
        }else return false;
    }
}