class Solution {
    long[][] memo;
    int mod = 1000000007;
    public int countVowelPermutation(int n) {
        memo=new long[26][n+1];
        for(long[] arr: memo) Arrays.fill(arr,-1);
        long ways = 0L;
        char[] chars = new char[]{'a','e','i','o','u'};
        for(char c: chars){
            ways=(ways+dp(n-1,c))%mod;
        }
        return (int)(ways);
    }
    public long dp(int n,char v){
        if(n==0) return 1;
        if(memo[v-'a'][n]!=-1) return memo[v-'a'][n];
        long ways=0L;
        if(v=='a'){
            ways=dp(n-1,'e')%mod;
        }else if(v=='e'){
            ways=(dp(n-1,'a')+dp(n-1,'i'))%mod;
        }else if(v=='i'){
            ways=(dp(n-1,'a')+dp(n-1,'e')+dp(n-1,'o')+dp(n-1,'u'))%mod;
        }else if(v=='o'){
            ways=(dp(n-1,'i')+dp(n-1,'u'))%mod;
        }else{
            ways=dp(n-1,'a')%mod;
        }
        memo[v-'a'][n]=ways;
        return ways;
    }
}