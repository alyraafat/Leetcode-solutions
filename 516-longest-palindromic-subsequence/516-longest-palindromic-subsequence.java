class Solution {
    int[][] memo;
    public int longestPalindromeSubseq(String s) {
        memo=new int[s.length()][s.length()];
        for(int[] arr: memo){
            Arrays.fill(arr,-1);
        }
        return dp(0,s.length()-1,s);
    }
    public int dp(int i,int j, String s){
        if(i==j) return 1;
        if(i>j) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int ans=0;
        if(s.charAt(i)==s.charAt(j)){
            ans=Math.max(ans,2+dp(i+1,j-1,s));
        }else{
            ans=Math.max(ans,Math.max(dp(i+1,j,s),dp(i,j-1,s)));
        }
        memo[i][j] = ans;
        return ans;
    }
}