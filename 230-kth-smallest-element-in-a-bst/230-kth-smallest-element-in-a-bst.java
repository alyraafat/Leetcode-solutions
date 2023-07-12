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
    ArrayList<Integer> inOrder = new ArrayList<>();
    int c = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return inOrder.get(k-1);
    }
    public void helper(TreeNode node,int k){
        if(node==null) return;
        helper(node.left,k);
        inOrder.add(node.val);
        c++;
        if(c>=k) return;
        helper(node.right,k);
    }
    
}