class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {
        memo=new int[coins.length][amount+1];
        for(int[] arr: memo) Arrays.fill(arr,-1);
        return dp(0,amount,coins);
        
    }
    public int dp(int i,int amount, int[] coins){
        if(amount==0) return 1;
        if(i==coins.length||amount<0) return 0;
        if(memo[i][amount]!=-1) return memo[i][amount];
        int ways=dp(i+1,amount,coins)+dp(i,amount-coins[i],coins);
        memo[i][amount]=ways;
        return ways;
    }
}