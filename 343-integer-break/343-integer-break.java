class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        return dp(n);
    }
    public int dp(int num){
        if(num==0) return 1;
        if(memo.containsKey(num)) return memo.get(num);
        int prod = 1;
        for(int i=1;i<=num;i++){
            if(num-i<0) break;
            int k = i*dp(num-i);
            prod = Math.max(prod,k);
        }
        memo.put(num,prod);
        return prod;
    }
}