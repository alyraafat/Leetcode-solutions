class Solution {
//     bottom up approach
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // int m = obstacleGrid.length;
            // int n = obstacleGrid[0].length;
            // int dp[][] = new int[m][n];
            // dp[0][0] = 1;
            // if(obstacleGrid[0][0]==1) return 0;
            // for (int row = 0; row < m; row++) {
            //     for (int col = 0; col < n; col++) {
            //         if(obstacleGrid[row][col]==1) continue;
            //         if (row > 0 && obstacleGrid[row-1][col]!=1) {
            //             dp[row][col] += dp[row - 1][col];
            //         }
            //         if (col > 0 && obstacleGrid[row][col-1]!=1) {
            //             dp[row][col] += dp[row][col - 1];
            //         }
            //     }
            // }
            // return dp[m - 1][n - 1];
//     }
    
    //-----------------------------
    
    // top down approach
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j]=-1;
            }
        }
        return dp(memo,obstacleGrid,m-1,n-1);
    }
    public int dp(int[][] memo, int[][] obstacleGrid, int i, int j){
        if(i+j==0) return 1;
        if(obstacleGrid[i][j]==1) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int ways = 0;
        if(i>0){
            ways+= dp(memo,obstacleGrid,i-1,j);
        }
        if(j>0){
            ways+= dp(memo,obstacleGrid,i,j-1);
        }
        memo[i][j] = ways;
        return memo[i][j];
    }
}