class Solution {
    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int[] arr: memo) Arrays.fill(arr,-1);
        return topdown(grid,0,0,memo);
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