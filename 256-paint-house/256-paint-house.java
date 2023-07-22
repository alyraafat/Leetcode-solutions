class Solution {
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        dp[0] = costs[0];
        for(int i=1;i<costs.length;i++){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<3;j++){
            min=Math.min(min,dp[dp.length-1][j]);
        }
        return min;
    }
}