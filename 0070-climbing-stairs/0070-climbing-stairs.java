class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        for(int i=0;i<=n;i++) memo[i] = -1;
        return topdown(n);
    }
    public int topdown(int i){
        if(i==0) return 1;
        if(i<0) return 0;
        if(memo[i]!=-1) return memo[i];
        memo[i] = topdown(i-1)+topdown(i-2);
        return memo[i];
    }
}