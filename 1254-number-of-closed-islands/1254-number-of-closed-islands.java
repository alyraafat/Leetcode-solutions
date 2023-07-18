class Solution {
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] seen;
    int m;
    int n;
    public int closedIsland(int[][] grid) {
        int ans=0;
        m=grid.length;
        n=grid[0].length;
        seen = new boolean[m][n];
        for(int i=0;i<m;i++){
            seen[i][0]=true;
            seen[i][n-1]=true;
            if(grid[i][0]==0){
                dfs(i,0,grid);
            }
            if(grid[i][n-1]==0){
                dfs(i,n-1,grid);
            }
        }
        for(int i=0;i<n;i++){
            seen[0][i]=true;
            seen[m-1][i]=true;
            if(grid[0][i]==0){
                dfs(0,i,grid);
            }
            if(grid[m-1][i]==0){
                dfs(m-1,i,grid);
            }
        }
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(!seen[i][j]){
                    seen[i][j]=true;
                    if(grid[i][j]==0){
                        ans++;
                        dfs(i,j,grid);
                    }
                }
            }
        }
        return ans;
    }
    public void dfs(int row,int col,int[][] grid){
        for(int[] d: directions){
            int newRow=row+d[0];
            int newCol=col+d[1];
            if(valid(newRow,newCol,grid)&&!seen[newRow][newCol]){
                seen[newRow][newCol]=true;
                dfs(newRow,newCol,grid);
            }
        }
    }
    public boolean valid(int row,int col,int[][] grid){
        return row>=0&&row<m&&col>=0&&col<n&&grid[row][col]==0;
    }
}