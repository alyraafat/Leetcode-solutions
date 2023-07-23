class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int numSquares(int n) {
        return dp(n);
    }
    public int dp(int n){
        if(n==0) return 0;
        if(n<0) return Integer.MAX_VALUE;
        if(memo.containsKey(n)) return memo.get(n);
        int res=Integer.MAX_VALUE;
        int i=1;
        while(i*i<=n){
            int x = dp(n-i*i);
            if(x==Integer.MAX_VALUE) break;
            res=Math.min(res,1+x);
            i++;
        }
        memo.put(n,res);
        return res;
    }
}