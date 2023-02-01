
//The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
//You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
//For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. 
//If there is no next greater element, then the answer for this query is -1.
//Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>(); 
        for(int i=0;i<nums2.length;i++){
            if(queue.isEmpty()){
                queue.addLast(nums2[i]);
            }else{
                while(!queue.isEmpty()&&nums2[i]>queue.getLast()){
                    m.put(queue.removeLast(),nums2[i]);
                }
                queue.addLast(nums2[i]);
            }
        }
        while(!queue.isEmpty()){
            m.put(queue.removeLast(),-1);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i]=m.get(nums1[i]);
        }
        return ans;
        
    }
}
