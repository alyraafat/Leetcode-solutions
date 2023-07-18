class Solution {
    int m;
    int n;
    // boolean[][] seen;
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        // seen = new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // if(!seen[i][j]){
                //     seen[i][j] = true;
                if(grid[i][j]==1) {
                    ans+=calculatePerimeter(i,j,grid);
                }
                // }
                
            }
        }
        return ans;
    }
    public int calculatePerimeter(int row, int col,int[][] grid){
        int ans=0;
        for(int[] dir: directions){
            int newRow = dir[0]+row;
            int newCol = dir[1]+col;
            if(!valid(newRow,newCol)||(valid(newRow,newCol)&&grid[newRow][newCol]==0)){
                ans++;
            }
        }
        return ans;
    }
    public boolean valid(int row, int col){
        return row>=0&&row<m&&col>=0&&col<n;
    }
}