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
class BSTIterator {
    TreeNode root;
    ArrayList<Integer> ans;
    int i;
    public BSTIterator(TreeNode root) {
        this.root=root;
        ans = new ArrayList<>();
        inOrder();
        i=-1;
    }
    public void inOrder(){
        helper(root);
    }
    public void helper(TreeNode node){
        if(node==null) return;
        helper(node.left);
        ans.add(node.val);
        helper(node.right);
    }
    
    public int next() {
        i++;
        return ans.get(i);
    }
    
    public boolean hasNext() {
        return i<ans.size()-1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */