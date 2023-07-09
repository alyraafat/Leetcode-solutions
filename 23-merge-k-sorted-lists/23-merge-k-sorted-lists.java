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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode currList = lists[i];
            while(currList!=null){
                pq.add(currList.val);
                currList=currList.next;
            }
        }
        ListNode prev = ans;
        while(!pq.isEmpty()){
            ListNode newNode = new ListNode(pq.poll());
            if(ans==null){
                ans=newNode;
                prev=ans;
                continue;
            }
            prev.next=newNode;
            prev=newNode;
        }
        return ans;
    }
}