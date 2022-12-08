//Given the head of a singly linked list and two integers left and right where left <= right, 
//reverse the nodes of the list from position left to position right, and return the reversed list.

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right) return head;
        ListNode curr = head;
        ListNode prev = null;
        int i = 1;
        while(i<left){
            prev = curr;
            curr = curr.next;
            i++;
        }
       // System.out.println(curr.val);
        ListNode n = curr;
        ListNode x = null;
        while(i<=right){
            if(i==right) x = n;
            n = n.next;
            i++;
        }
        if(prev!=null) prev.next = null;
        x.next = null;
        //System.out.println(n.val);
        ListNode nextNode = curr.next;
        ListNode prev2 = null;
        ListNode tail = curr;
        while(curr!=null){
            curr.next=prev2;
            prev2 = curr;
            curr = nextNode;
            if(nextNode!=null) nextNode = nextNode.next;
        }
       // System.out.println(prev2.val);
        tail.next = n;
        if(prev!=null) prev.next = prev2;
        else{
            head = prev2;
        }
        return head;
    }
}
