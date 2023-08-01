/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(node.val);
        q.add(node);
        HashMap<Node,Node> seen = new HashMap<>();
        seen.put(node,root);
        while(!q.isEmpty()){
            Node currNode = q.remove();
            Node newNode = seen.containsKey(currNode)?seen.get(currNode):new Node(currNode.val);
            if(!seen.containsKey(currNode))seen.put(currNode,newNode);
            for(int j=0;j<currNode.neighbors.size();j++){
                Node currN = currNode.neighbors.get(j);
                Node newN = seen.containsKey(currN)?seen.get(currN):new Node(currN.val);
                if(!seen.containsKey(currN)){
                    seen.put(currN,newN);
                    q.add(currN);
                }
                newNode.neighbors.add(newN);
            }
        }
        return root;
    }
}