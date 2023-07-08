/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        int size=0;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        if(size==0||size==1||k%size==0) return head;
        k%=size;
        curr=head;
        ListNode prev=null;
        for(int i=1;i<=size-k;i++){
            prev=curr;
            curr=curr.next;
        }
        ListNode newHead=curr;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;
        prev.next=null;
        head=newHead;
        return head;
    }
}