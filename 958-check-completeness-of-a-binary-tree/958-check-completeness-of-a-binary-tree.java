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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        boolean full = true;
        boolean prev = true;
        while(!q.isEmpty()){
            int size = q.size();
            if(size<Math.pow(2,level)) {
                prev = full;
                full = false;
                if(!prev) return false;
            } 
            boolean lefts = true;
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                if(curr.left!=null) {
                    if(lefts)q.add(curr.left);
                    else return false;
                }else lefts=false;
                if(curr.right!=null) {
                    if(lefts)q.add(curr.right);
                    else return false;
                }
                else lefts=false;
            }
            level++;
        }
        return true;
    }
}