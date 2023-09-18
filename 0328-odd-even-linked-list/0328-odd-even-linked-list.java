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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode prev = null;
        int i = 1;
        while(next!=null){  
            curr.next = next.next;
            prev = curr;
            curr=next;
            if(next!=null)
                next = next.next;
            i++;
        }
        if(i%2==1)
            curr.next = even;
        else
            prev.next = even;
        return odd;
        
    }
}