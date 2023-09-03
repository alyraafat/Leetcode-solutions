class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        return bottomUp(nums,multipliers);
        // return topDown(nums,multipliers);
    }
    public int bottomUp(int[] nums, int[] multipliers){
        int[][] dp = new int[nums.length+1][multipliers.length+1];
        int n = nums.length;
        int m = multipliers.length;
        for(int j=m-1;j>=0;j--){
            for(int i=j;i>=0;i--){
                int r = n-1-(j-i);
                dp[i][j] = Math.max(nums[i]*multipliers[j]+dp[i+1][j+1],nums[r]*multipliers[j]+dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
    public int topDownHelper(Integer[][] memo,int[] nums, int[] multipliers,int i, int j){
        if(j==multipliers.length){
            return 0;
        }
        int k = nums.length-(j-i)-1;
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        memo[i][j] = Math.max(nums[i]*multipliers[j]+topDownHelper(memo,nums,multipliers,i+1,j+1),nums[k]*multipliers[j]+topDownHelper(memo,nums,multipliers,i,j+1));
        return memo[i][j];
    }
    public int topDown(int[] nums, int[] multipliers){
        Integer[][] memo = new Integer[nums.length][multipliers.length];
        return topDownHelper(memo,nums,multipliers,0,0);
    }
}