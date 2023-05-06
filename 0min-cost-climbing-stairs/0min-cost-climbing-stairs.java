class Solution {
    HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dp(cost.length-1, cost),dp(cost.length-2,cost));   
    }
    public int dp(int i, int[] cost){
        if(i==0) return cost[0];
        if(i==1) return cost[1];
        if(memo.containsKey(i)) return memo.get(i);
        memo.put(i,Math.min(dp(i-1,cost),dp(i-2,cost))+cost[i]);
        return memo.get(i);
    }
}