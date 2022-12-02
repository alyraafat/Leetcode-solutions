//Given an array of integers nums, you start with an initial positive value startValue.
//In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
//Return the minimum positive value of startValue such that the step by step sum is never less than 1.

class Solution {
    public int minStartValue(int[] nums) {
        int startValue = 1;
        int sum = startValue;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum<1){
                startValue++;
                sum=startValue;
                i=-1;
            }
        }
        return startValue;
    }
}
