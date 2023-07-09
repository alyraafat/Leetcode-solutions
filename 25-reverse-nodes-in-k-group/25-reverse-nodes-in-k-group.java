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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1||head.next==null||head==null) return head;
        ListNode s = head;
        int size=0;
        while(s!=null){
            s=s.next;
            size++;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        for(int j=0;j<size/k;j++){
            int i = fast==head?2:1;
            for(;i<=k;i++){
                fast=fast.next;
            }
            if(i<=k) break;
            // System.out.println(slow.next.val+","+fast.val);
            ListNode nextNode = fast.next;
            reverse(prev,slow,fast,nextNode);
            if(slow==head){
                head=fast;
            }
            fast=slow;
            prev=slow;
            slow=slow.next;
        }
        return head; 
    }
    public void reverse(ListNode prev,ListNode slow,ListNode fast,ListNode nextNode){
        ListNode curr = slow;
        ListNode prev2 = prev;
        ListNode next = null;
        while(curr!=nextNode){
            next = curr.next;
            curr.next=prev2;
            prev2=curr;
            curr=next;
        }
        slow.next = nextNode;
        if(prev!=null) prev.next=fast;
    }
}