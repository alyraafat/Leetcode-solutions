class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        memo=new int[s.length()][t.length()];
        for(int[] arr: memo) Arrays.fill(arr,-1);
        return dp(0,0,s,t);
    }
    public int dp(int i, int j, String s, String t){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int ways=0;
        if(s.charAt(i)==t.charAt(j)){
            ways+=dp(i+1,j+1,s,t)+dp(i+1,j,s,t);
        }else{
            ways+=dp(i+1,j,s,t);
        }
        memo[i][j]=ways;
        return ways;
    }
}