class Solution {
    int ans;
    boolean[][] seen;
    int[][] dir = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!seen[i][j]&&grid[i][j]=='1'){
                    seen[i][j]=true;
                    ans++;
                    dfs(i,j,grid);
                }
            }
        }   
        return ans;
    }
    public void dfs(int row,int col, char[][] grid){
        for(int[] d: dir){
            int newRow = row+d[0];
            int newCol = col+d[1];
            if(valid(newRow,newCol,grid.length,grid[0].length)&&grid[newRow][newCol]=='1'){
                seen[newRow][newCol]=true;
                dfs(newRow,newCol,grid);
            }
        }
    }
    public boolean valid(int row, int col, int m,int n){
        if(row<0||row>=m||col<0||col>=n||seen[row][col]) return false;
        return true;
    }
}
      