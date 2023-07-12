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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,1));
        int width = 1;
        int start = -1;
        int last = -1;
        while(!q.isEmpty()){
            int size = q.size();
            start = -1;
            last = -1;
            for(int i=1;i<=size;i++){
                Pair<TreeNode,Integer> p = q.remove();
                TreeNode node = p.getKey();
                Integer index = p.getValue();
                if(node.left!=null)q.add(new Pair<>(node.left,2*index));
                if(node.right!=null)q.add(new Pair<>(node.right,2*index+1));
                if(i==1) start = index;
                last = index;
            }
            width = Math.max(width,last-start+1);
        }
        return width;
    }
}