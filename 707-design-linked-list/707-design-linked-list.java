class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val, ListNode next){
        this.val=val;
        this.next=next;
    }
}
class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size=0;
    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index>=size) return -1;
        ListNode curr = head;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        ListNode curr = new ListNode(val,head);
        head=curr;
        if(curr.next==null) tail=curr;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode curr = new ListNode(val);
        if(tail==null){
            tail=curr;
            head=curr;
        }else{
            tail.next=curr;
            tail=curr;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size) return;
        if(index==0) {
            this.addAtHead(val);
            return;
        }else if(index==size){
            this.addAtTail(val);
            return;
        }
        ListNode curr = head;
        for(int i=0;i<index-1;i++){
            curr=curr.next;
        }
        ListNode insert = new ListNode(val);
        ListNode temp = curr.next;
        curr.next=insert;
        insert.next=temp;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index>=size) return;
        if(index==0){
            head=head.next;
            if(head==null) tail=null;
            size--;
            return;
        }
        ListNode curr = head;
        for(int i=0;i<index-1;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        if(index==size-1){
            tail=curr;    
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */