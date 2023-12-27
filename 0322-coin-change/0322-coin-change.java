class Solution {
    public int coinChange(int[] coins, int amount) {
   
        int[] dp = new int[amount+1];
        // int ans = 0;
        // for(int i=0;i<maxCoin+1;i++){
        //     for(int j=0;j<)
        //     }
        // return ans==0?-1:ans;
        int topdownAns = topdown(dp,amount,coins);
        return topdownAns;
    }
    
    public int topdown(int[] memo, int a,int[] coins){
        if(a<0){
            return -1;
        }
        if(a==0){
            return 0;
        }
        if(memo[a]!=0){
            return memo[a];
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<coins.length;j++){
            int res = topdown(memo,a-coins[j],coins);
            if (res!=-1) {
                min = Math.min(min,1+res);
            }
        }
        memo[a] = min==Integer.MAX_VALUE? -1: min;
        return memo[a];
    }
}