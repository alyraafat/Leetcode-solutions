class Solution {
    public int longestArithSeqLength(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            min= Math.min(min,num);
            max = Math.max(max,num);
        }
        int diff = max-min+1;
        int[][] dp = new int[nums.length][2*diff];
        for(int[] arr: dp) Arrays.fill(arr,1);
        int res = 0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                int d = nums[i]-nums[j];
                dp[i][d+diff] = Math.max(dp[i][d+diff],1+dp[j][d+diff]);
                res = Math.max(res,dp[i][d+diff]);
            }
        }
        return res;
    }
}