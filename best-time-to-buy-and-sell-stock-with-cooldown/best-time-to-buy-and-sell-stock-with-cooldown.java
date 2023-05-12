class Solution {
    int[][][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    memo[i][j][k] = -1;
                }
            }
        }
        return dp(0,0,prices,0);
    }
    public int dp(int i, int holding,int[] prices,int cooldown){
        if(i==prices.length) return 0;
        if(memo[i][holding][cooldown]!=-1) return memo[i][holding][cooldown];
        int ans = dp(i+1,holding,prices,0);
        if(holding==0&&cooldown==0){
            ans = Math.max(ans,-prices[i]+dp(i+1,1,prices,0));
        }else if(holding==1){
            ans = Math.max(ans, prices[i]+dp(i+1,0,prices,1));
        }
        memo[i][holding][cooldown] = ans;
        return ans;
    }
}