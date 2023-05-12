class Solution {
    int[][] memo;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        memo = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                memo[i][j] = -1;
            }
        }
        return dp(0,0,prices,fee);
    }
    public int dp(int i, int holding,int[] prices,int fee){
        if(i==prices.length) return 0;
        if(memo[i][holding]!=-1) return memo[i][holding];
        int ans = dp(i+1,holding,prices,fee);
        if(holding==0){
            ans = Math.max(ans,-prices[i]+dp(i+1,1,prices,fee));
        }else {
            ans = Math.max(ans,-fee+prices[i]+dp(i+1,0,prices,fee));
        }
        memo[i][holding] = ans;
        return ans;
    }
}