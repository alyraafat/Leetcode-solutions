class Solution {
    int[] memo;
    int low,high,zero,one;
    int mod=1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        memo=new int[high+1];
        Arrays.fill(memo,-1);
        this.low=low;
        this.high=high;
        this.zero=zero;
        this.one=one;
        return dp(0);
    }
    public int dp(int len){
        if(len>high) return 0;
        if(memo[len]!=-1) return memo[len];
        memo[len] = dp(len+zero)+dp(len+one);
        if(len>=low&&len<=high) memo[len]++;
        memo[len]%=mod;
        return memo[len];
    }
}