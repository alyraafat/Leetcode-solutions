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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans =null;
        ListNode curr3=ans;
        int carry=0;
        ListNode curr1=l1;
        ListNode curr2=l2;
        while(curr1!=null||curr2!=null){
            if(curr1!=null&&curr2!=null){
                int sum = carry+curr1.val+curr2.val;
                carry=0;
                if(sum>9){
                    carry=1;
                    sum%=10;
                }
                if(curr3==null) {
                    curr3=new ListNode(sum);
                    ans=curr3;
                }
                else {
                    curr3.next=new ListNode(sum);
                    curr3=curr3.next;
                }
                curr1=curr1.next;
                curr2=curr2.next;
            }else if(curr1!=null){
                int sum = carry+curr1.val;
                carry=0;
                if(sum>9){
                    carry=1;
                    sum%=10;
                }
                if(curr3==null) {
                    curr3=new ListNode(sum);
                    ans=curr3;
                }
                else {
                    curr3.next=new ListNode(sum);
                    curr3=curr3.next;
                }
                curr1=curr1.next;
            }else if(curr2!=null){
                int sum = carry+curr2.val;
                carry=0;
                if(sum>9){
                    carry=1;
                    sum%=10;
                }
                if(curr3==null) {
                    curr3=new ListNode(sum);
                    ans=curr3;
                }
                else {
                    curr3.next=new ListNode(sum);
                    curr3=curr3.next;
                }         
                curr2=curr2.next;
            }
        }
        if(carry==1){
           curr3.next=new ListNode(1);
        }
        return ans;
    }
}