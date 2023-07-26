class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp=new int[prices.length][k+1][2];
        for(int i=0;i<dp.length;i++){
            for(int[] arr: dp[i])
                Arrays.fill(arr,-1);
        }
        return profit(0,k,prices,0);
    }
    public int profit(int i, int k, int[] prices, int buy){// buy=1, sell=0
        if(i==prices.length||k==0) return 0;
        if(dp[i][k][buy]!=-1) return dp[i][k][buy];
        if(buy==0){
            int bought = profit(i+1,k,prices,1)-prices[i];
            int skip = profit(i+1,k,prices,0);
            dp[i][k][buy]=Math.max(bought,skip);
        }else{
            int sell = profit(i+1,k-1,prices,0)+prices[i];
            int skip = profit(i+1,k,prices,1);
            dp[i][k][buy]=Math.max(sell,skip);
        }
        return dp[i][k][buy];
        
    }
}