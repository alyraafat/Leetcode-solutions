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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextNode = curr.next;
        head=curr.next;
        while(curr!=null&&curr.next!=null){
            curr.next=nextNode.next;
            nextNode.next=curr;
            if(prev!=null)prev.next=nextNode;
            prev=curr;
            curr=curr.next;
            if(curr!=null&&curr.next!=null){
                nextNode=curr.next;                
            }
        }
        return head;
    }
}