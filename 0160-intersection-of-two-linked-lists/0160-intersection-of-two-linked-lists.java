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
        //Approach 1
        // ListNode currA = headA;
        // HashSet<ListNode> set  = new HashSet<>();
        // while(currA!=null){
        //     set.add(currA);
        //     currA = currA.next;
        // }
        // ListNode currB = headB;
        // while(currB!=null){
        //     if(set.contains(currB)){
        //         return currB;
        //     }
        //     currB = currB.next;
        // }
        // return null;
        //--------------------------
        //approach 2
        ListNode currA = headA;
        int a = 0;
        while(currA!=null){
            currA = currA.next;
            a++;
        }
        ListNode currB = headB;
        int b = 0;
        while(currB!=null){
            currB = currB.next;
            b++;
        }
        ListNode curr = a>b?headA:headB;
        for(int i=0;i<Math.abs(a-b);i++){
            curr=curr.next;
        }
        currA = a>b?curr:headA;
        currB = a>b?headB:curr;
        while(currA!=null){
            if(currA==currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }
        return null;
        
    }
}