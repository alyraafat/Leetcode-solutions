class Solution {
    int m;
    int n;
    boolean[][] seen;
    int[][] dir = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    boolean sub = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        seen=new boolean[m][n];
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!seen[i][j]&&grid2[i][j]==1){
                    seen[i][j]=true;
                    sub=true;
                    dfs(i,j,grid1,grid2);
                    if(sub) ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int row, int col,int[][] grid1,int[][] grid2){
        if(grid2[row][col]==1&&grid1[row][col]!=grid2[row][col]) sub=false;
        for(int[] d: dir){
            int newRow = d[0]+row;
            int newCol = d[1]+col;
            if(valid(newRow,newCol,grid2)&&!seen[newRow][newCol]){
                seen[newRow][newCol]=true;
                dfs(newRow,newCol,grid1,grid2);
            }
        }
    }
    public boolean valid(int row, int col,int[][] grid){
        return row>=0&&row<m&&col>=0&&col<n&&grid[row][col]==1;
    }
}