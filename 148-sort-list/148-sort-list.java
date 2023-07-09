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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode mid = getMid(head);
        ListNode l = sortList(head);
        ListNode r = sortList(mid);
        head = merge(l,r);
        return head;
    }
    public ListNode getMid(ListNode head){
        int size=0;
        ListNode curr = head;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        int mid = size/2;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev=null;
        for(int i=0;i<mid;i++){
            prev=fast;
            fast=fast.next;
        }
        
        prev.next=null;
        return  fast;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode dummyPointer = dummy;
        while(curr1!=null&&curr2!=null){
            if(curr1.val<curr2.val){
                dummyPointer.next = curr1;
                curr1=curr1.next;
            }else{
                dummyPointer.next = curr2;
                curr2=curr2.next;
            }
            dummyPointer=dummyPointer.next;
        }
        if(curr1!=null){
            dummyPointer.next = curr1;
        }else{
            dummyPointer.next=curr2;
        }
        return dummy.next;
    }
}