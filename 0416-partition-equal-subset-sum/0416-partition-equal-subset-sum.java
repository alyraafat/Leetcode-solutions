class Solution {
    public boolean canPartition(int[] nums) {
        //topdown
        // int sum = 0;
        // for(int num : nums) sum+=num;
        // if(sum%2!=0) return false;
        // Boolean[][] memo = new Boolean[nums.length][sum/2 +1];
        // return topdown(memo,0,sum/2,nums);
        //-----------------------------------------------
        //bottomup
        return bottomup(nums);
    }
    public boolean bottomup(int[] nums){
        int sum = 0;
        for(int num : nums) sum+=num;
        if(sum%2!=0) return false;
        boolean[][] dp = new boolean[nums.length][sum/2 +1];
        for(int i=0;i<dp.length;i++){
            if(nums[i]>sum/2) return false;
            dp[i][nums[i]] = true;
        }
        for(int i=0;i<dp.length;i++){
            for(int j=nums[i]+1;j<sum/2+1;j++){
                for(int k=0;k<i;k++){
                    if(dp[k][j-nums[i]] == true){
                        dp[i][j] = true;
                        break;
                    }
                }
                
            }
        }
        boolean res = false; 
        for(int i=0;i<dp.length;i++){
            res = res||dp[i][sum/2];
        }
        return res;
    }
    public boolean topdown(Boolean[][] memo,int i, int sum, int[] nums){
        if(sum<0) return false;
        if(sum==0) return true;
        if(i==nums.length) return false;
        if(memo[i][sum]!=null) return memo[i][sum];
        memo[i][sum] = topdown(memo,i+1,sum,nums)||topdown(memo,i+1,sum-nums[i],nums);
        return memo[i][sum];
    }
}