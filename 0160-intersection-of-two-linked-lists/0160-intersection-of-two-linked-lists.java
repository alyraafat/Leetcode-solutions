/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        HashSet<ListNode> set  = new HashSet<>();
        while(currA!=null){
            set.add(currA);
            currA = currA.next;
        }
        ListNode currB = headB;
        while(currB!=null){
            if(set.contains(currB)){
                return currB;
            }
            currB = currB.next;
        }
        return null;
    }
}