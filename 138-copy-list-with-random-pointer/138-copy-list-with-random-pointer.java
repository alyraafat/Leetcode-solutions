/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr=head;
        HashMap<Node,Node> map = new HashMap<>(); 
        Node beforeHead = null;
        while(curr!=null){
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }
        curr=head;
        while(curr!=null){
            Node curr2 = map.get(curr);
            if(beforeHead==null) beforeHead=curr2;
            if(curr.next!=null)
                curr2.next = map.get(curr.next);
            if(curr.random!=null)
                curr2.random = map.get(curr.random);
            curr=curr.next;
        }
        return beforeHead;
    }
}