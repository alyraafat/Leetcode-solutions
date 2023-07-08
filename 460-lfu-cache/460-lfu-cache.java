class LFUCache {
    int capacity;
    HashMap<Integer,Node> map;
    HashMap<Integer,Pair<Node,Node>> mapFreq;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        map = new HashMap<>();
        mapFreq = new HashMap<>();
    } 
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        map.get(key).counter++;
        this.remove(map.get(key).counter-1,map.get(key));
        this.add(map.get(key).counter,map.get(key));
        return map.get(key).val;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).counter++;
            map.get(key).val=value;
            this.remove(map.get(key).counter-1,map.get(key));
            this.add(map.get(key).counter,map.get(key));
            return;
        }
        if(map.size()==capacity){
            int k = getMax();
            Node removed = this.removeFirst(k);
            map.remove(removed.key);
        }
        map.put(key,new Node(key,value));
        this.add(map.get(key).counter,map.get(key));
    }
    public Node removeFirst(int c){
        Pair<Node,Node> pair = mapFreq.get(c);
        Node head = pair.getKey();
        Node removed = head.next;
        head.next=removed.next;
        head.next.prev=head;
        if(head.next==pair.getValue()){
            mapFreq.remove(c);
        }
        return removed;
    }
    public int getMax(){
        int min = Integer.MAX_VALUE;
        for(int key: mapFreq.keySet()){
            min = Math.min(min,key);
        }
        return min;
    }
    public void remove(int c,Node n){
        Node prev = n.prev;
        Node next = n.next;
        prev.next=next;
        next.prev=prev;
        Pair<Node,Node> pair = mapFreq.get(c);
        if(pair.getKey().next==pair.getValue()){
            mapFreq.remove(c);
        }
    }
    public void add(int c,Node n){
        if(!mapFreq.containsKey(c)){
            Node head = new Node(0,0);
            Node tail = new Node(0,0);
            head.next=tail;
            tail.prev=head;
            mapFreq.put(c,new Pair<>(head,tail));
        }
        Pair<Node,Node> pair = mapFreq.get(c);
        Node tail = pair.getValue();
        Node prev = tail.prev;
        prev.next=n;
        n.prev=prev;
        n.next=tail;
        tail.prev=n;
    }
}
class Node{
    int key;
    int val;
    int counter;
    Node next;
    Node prev;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        this.counter=1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */