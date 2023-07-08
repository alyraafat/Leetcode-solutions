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
    public ListNode insertionSortList(ListNode head) {
        ListNode beforeHead = null;
        ListNode curr=head;
        while(curr!=null){
            ListNode newNode = new ListNode(curr.val);
            beforeHead=insert(newNode,beforeHead);
            curr=curr.next;
        }
        return beforeHead;
    }
    public ListNode insert(ListNode ins,ListNode head){
        if(head==null){
            head=ins;
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null&&curr.val<ins.val){
            prev=curr;
            curr=curr.next;
        }
        if(curr==null){
            prev.next=ins;
        }else{
            if(curr==head){
                ins.next=head;
                head=ins;
            }else{
                prev.next=ins;
                ins.next=curr; 
            }
        }
        return head;
    }
}