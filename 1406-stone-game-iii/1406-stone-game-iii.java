class Solution {
    int[] memo;
    int sum;
    public String stoneGameIII(int[] stoneValue) {
        memo=new int[stoneValue.length];
        Arrays.fill(memo,-1);
        int diff = dp(0,stoneValue);
        return diff>0?"Alice":(diff==0?"Tie":"Bob");
    }
    public int dp(int i,int[] stoneValue){
        if(i==stoneValue.length) return 0;
        if(memo[i]!=-1) return memo[i];
        int res = stoneValue[i]-dp(i+1,stoneValue);
        if(i+2<=stoneValue.length) res=Math.max(res,stoneValue[i]+stoneValue[i+1]-dp(i+2,stoneValue));
        if(i+3<=stoneValue.length) res=Math.max(res,stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-dp(i+3,stoneValue));
        return memo[i]=res;
    }
}