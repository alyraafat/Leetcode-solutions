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
        if(left==right) return head;
        ListNode beforeFirst = null;
        ListNode first = head;
        ListNode last = head;
        ListNode afterLast = null;
        for(int i=1;i<right;i++){
            if(i<left){
                beforeFirst=first;
                first=first.next;
            }
            last=last.next;
        }
        if(last==null&&first==null) return head;
        if(beforeFirst==null) head=last;
        afterLast=last.next;
        ListNode prev = null;
        ListNode curr=first;
        ListNode nextNode = curr.next;
        while(curr!=null&&curr!=afterLast){
            curr.next=prev;
            prev=curr;
            curr=nextNode;
            if(nextNode!=null) nextNode=nextNode.next;
        }
        first.next=afterLast;
        if(beforeFirst!=null)beforeFirst.next=last;
        return head;
    }
}