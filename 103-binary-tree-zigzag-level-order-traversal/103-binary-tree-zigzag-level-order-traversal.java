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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        q.add(root);
        boolean right = false;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                if(!right){
                    temp.add(node.val);
                }else{
                    temp.add(0, node.val);
                }
            }
            ans.add(temp);
            right = !right;
        }
        return ans;
    }
}
