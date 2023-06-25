class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        return Math.max(dp(nums,0,nums.length-1),dp(nums,1,nums.length));
    }
    int dp(int[] nums, int start,int end){
        int[] dp =new int[end-start];
        dp[0] = nums[start];
        if(dp.length>1){
            dp[1] = Math.max(dp[0],nums[start+1]);
        }
        for(int i=start+2;i<end;i++){
            dp[i-start] = Math.max(dp[i-start-2]+nums[i],dp[i-start-1]); 
        }
        return dp[dp.length-1];
    }
}