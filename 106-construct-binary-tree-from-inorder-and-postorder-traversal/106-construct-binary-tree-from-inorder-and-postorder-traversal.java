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
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return root;
    }
    public TreeNode helper(int[] inorder, int iStart,int iEnd,int[] postorder,int pStart, int pEnd){
        if(pEnd<pStart||iEnd<iStart) return null;
        TreeNode curr = new TreeNode(postorder[pEnd]);
        int i = map.get(postorder[pEnd]);
        curr.left = helper(inorder,iStart,i-1,postorder,pStart,pStart+(i-iStart)-1);
        curr.right = helper(inorder,i+1,iEnd,postorder,pStart+(i-iStart),pEnd-1);
        return curr;
    }
}