class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum+=num;
        if(sum%2!=0) return false;
        Boolean[][] memo = new Boolean[nums.length][sum/2 +1];
        return topdown(memo,0,sum/2,nums);
    }
    // public boolean bottomup(int[] nums){
    //     int sum = 0;
    //     for(int num : nums) sum+=num;
    //     if(sum%2!=0) return false;
    //     Boolean[][] dp = new Boolean[nums.length][sum/2 +1];
    //     for(int i=0;i<dp.length;i++){
    //         for(int j=0;j<sum+1;j++){
    //             if(dp[i][j-nums[i]]){
    //                 dp[i][j] = true;
    //             }
    //         }
    //     }
    // }
    public boolean topdown(Boolean[][] memo,int i, int sum, int[] nums){
        if(sum<0) return false;
        if(sum==0) return true;
        if(i==nums.length) return false;
        if(memo[i][sum]!=null) return memo[i][sum];
        memo[i][sum] = topdown(memo,i+1,sum,nums)||topdown(memo,i+1,sum-nums[i],nums);
        return memo[i][sum];
    }
}