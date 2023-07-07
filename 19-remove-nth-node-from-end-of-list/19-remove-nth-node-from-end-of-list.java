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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        if(head==null||head.next==null) return null;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
            if(prev!=null) prev=prev.next;
            else prev=head;
        }
        if(prev==null) head=head.next;
        else prev.next= slow.next;
        slow.next=null;
        return head;
    }
}