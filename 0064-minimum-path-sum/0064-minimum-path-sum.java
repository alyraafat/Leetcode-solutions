class Solution {
    public int minPathSum(int[][] grid) {
        //topdown
        // int[][] memo = new int[grid.length][grid[0].length];
        // for(int[] arr: memo) Arrays.fill(arr,-1);
        // return topdown(grid,0,0,memo);
        //---------------------------------------------------
        //bottomup
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0&&j==0) continue;
                int up = i==0?Integer.MAX_VALUE: dp[i-1][j];
                int left = j==0?Integer.MAX_VALUE: dp[i][j-1];
                dp[i][j] = Math.min(up,left)+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
    public int topdown(int[][] grid,int i, int j, int[][] memo){
        if(i==grid.length-1&&j==grid[0].length-1) return grid[i][j];
        if(memo[i][j]!=-1) return memo[i][j];
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(i<grid.length-1){
            down = topdown(grid,i+1,j,memo);
        }
        if(j<grid[0].length-1){
            right = topdown(grid,i,j+1,memo);
        }
        memo[i][j] = grid[i][j]+Math.min(down,right);
        return memo[i][j];
    }
}