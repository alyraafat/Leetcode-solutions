class LRUCache {
    HashMap<Integer,Integer> map;
    HashMap<Integer,Node> mapNodes;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();
        mapNodes= new HashMap<>();
    }
    
    public int get(int key) {
        // System.out.println("get: "+key+": "+map);
        if(!map.containsKey(key)) return -1;
        Node curr = mapNodes.get(key);
        this.remove(curr);
        this.add(curr);
        return map.get(key);
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            Node curr=mapNodes.get(key);
            this.remove(curr);
            this.add(curr);
            return;
        }
        if(map.size()==capacity){
            map.remove(head.key);
            mapNodes.remove(head.key);
            this.remove(head);
        }
        map.put(key,value);
        Node n = new Node(key);
        mapNodes.put(key,n);
        this.add(n);
        // System.out.print("put "+key+","+value+":"+map);
    }
    public void remove(Node curr){
        if(curr!=tail){
            if(curr==head){
                head = head.next;
                head.prev=null;
            }else{
                Node nextNode = curr.next;
                Node prevNode = curr.prev;
                prevNode.next=nextNode;
                nextNode.prev= prevNode;
            }
        }else{
            tail=tail.prev;
            if(tail!=null) tail.next=null;
        }
    }
    public void add(Node curr){
        if(tail==null){
            head=curr;
            tail=curr;
        }else{
            tail.next=curr;
            curr.prev=tail;
            curr.next=null;
            tail=curr;
        }
    }
}
public class Node {
    int key;
    Node next;
    Node prev;
    public Node(int key) {
        this.key = key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */