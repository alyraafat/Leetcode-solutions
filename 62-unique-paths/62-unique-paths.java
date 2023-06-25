class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j] = -1;
            }
        }
        
        return dp(m-1,n-1);
    }
    int dp(int start, int end){
        if(start==0 && end==0) {
            return 1;
        }
        if(memo[start][end]!=-1) return memo[start][end];
        int ways = 0;
        if(end-1>=0)
            ways+=dp(start,end-1);
        if(start-1>=0)
            ways+=dp(start-1,end);
        memo[start][end] = ways;
        return memo[start][end];
    }
}