class Solution {
    int[][] memo;
    int[][] grid;
    public int minPathSum(int[][] grid) {
        this.grid=grid;
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(m - 1, n - 1);
    }
    public int dp(int i, int j){
        if(i==0&&j==0) return grid[i][j];
        if(memo[i][j]!=-1) return memo[i][j];
        int sum = grid[i][j];
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(i>0) up=dp(i-1,j);
        if(j>0) left=dp(i,j-1);
        sum += Math.min(left,up);
        memo[i][j]=sum;
        return sum;
    }
}