//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//Return the running sum of nums.

class Solution {
    public int[] runningSum(int[] nums) {
        int[] pre = new int[nums.length];
        if(nums.length>0){
            pre[0] = nums[0];
            for(int i=1;i<nums.length;i++){
                pre[i] = nums[i]+pre[i-1];
            }
        }
        
        return pre;
        
    }
}
