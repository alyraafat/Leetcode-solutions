class Solution {
    int[][] memo;
    int m;
    int n;
    int[][] directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    int[][] matrix;
    // int[][] seen;
    public int longestIncreasingPath(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        this.matrix=matrix;
        memo=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,dfs(i,j));
            }
        }
        return max;
    }
    public int dfs(int i, int j){
        if(memo[i][j]!=-1) return memo[i][j];
        int max=1;
        for(int[] dir: directions){
            int row = dir[0]+i;
            int col = dir[1]+j;
            if(valid(i,j,row,col)){
                max=Math.max(max,1+dfs(row,col));
            }
        }
        memo[i][j]=max;
        return max;
    }
    public boolean valid(int i, int j, int row, int col){
        return row>=0&&row<m&&col>=0&&col<n&&matrix[i][j]<matrix[row][col];
    }
}