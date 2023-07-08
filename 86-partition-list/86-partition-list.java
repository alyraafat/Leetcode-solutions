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
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode pointer = beforeHead;
        ListNode curr = head;
        ListNode firstBig = new ListNode(0);
        ListNode pointer2 = firstBig;
        while(curr!=null){
            ListNode currNode = new ListNode(curr.val);
            if(curr.val<x){
                pointer.next= currNode;
                pointer=pointer.next;
            }else{
                pointer2.next=currNode;
                pointer2=pointer2.next;
            }
            curr=curr.next;
        }
        beforeHead=beforeHead.next;
        firstBig=firstBig.next;
        pointer.next=firstBig;
        return beforeHead!=null?beforeHead:firstBig;
    }
}