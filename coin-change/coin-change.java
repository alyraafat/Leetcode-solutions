class Solution {
    HashMap<ArrayList<Integer>,Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=1;i<dp.length;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int coin:coins){
                int diff = i-coin;
                if(diff>=0&&dp[diff]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[diff]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
    
}