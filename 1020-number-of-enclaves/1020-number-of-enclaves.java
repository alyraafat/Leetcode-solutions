class Solution {
    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] seen;
    int m;
    int n;
    boolean boundary;
    public int numEnclaves(int[][] grid) {
        int ans=0;
        m=grid.length;
        n=grid[0].length;
        seen = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boundary=false;
                if(grid[i][j]==0) seen[i][j]=true;
                else if(!seen[i][j]){
                    seen[i][j]=true;
                    int count=dfs(i,j,grid);
                    if(!boundary){
                       ans+=count; 
                    }
                }
            }
        }
        return ans;
    }
    public int dfs(int row,int col,int[][] grid){
        int countSoFar=1;
        if(row==0||row==m-1||col==0||col==n-1){
            boundary=true;
        }
        for(int[] d: directions){
            int newRow=row+d[0];
            int newCol=col+d[1];
            if(valid(newRow,newCol,grid)&&!seen[newRow][newCol]){
                seen[newRow][newCol]=true;
                countSoFar+=dfs(newRow,newCol,grid);
            }
        }
        return countSoFar;
    }
    public boolean valid(int row,int col,int[][] grid){
        return row>=0&&row<m&&col>=0&&col<n&&grid[row][col]!=0;
    }
}