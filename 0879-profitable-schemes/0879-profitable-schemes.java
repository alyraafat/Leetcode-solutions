class Solution {
    int[][][] memo;
    int mod = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        memo = new int[group.length][n+1][minProfit+1];
        for(int i=0;i< memo.length;i++) 
            for(int j=0;j<memo[i].length;j++)
                Arrays.fill(memo[i][j],-1);
        return dp(0,group,profit,n,minProfit);
    }
    public int dp(int i,int[] group,int[] profit,int n,int minProfit){
        
        if(i==profit.length) {
            if(minProfit<=0) return 1;
            else return 0;
        }
        if(memo[i][n][minProfit]!=-1) return memo[i][n][minProfit];
        
        int skip = dp(i+1,group,profit,n,minProfit);
        memo[i][n][minProfit] = skip;
        if(n-group[i]>=0){
            memo[i][n][minProfit]+=(dp(i+1,group,profit,n-group[i],Math.max(0,minProfit-profit[i])));
        }
        memo[i][n][minProfit]%=mod;
        
        return memo[i][n][minProfit];
    }
}