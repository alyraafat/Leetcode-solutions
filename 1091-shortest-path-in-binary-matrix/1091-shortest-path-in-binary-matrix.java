class State {
    int row;
    int col;
    int steps;
    State(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
class Solution {
    int n;
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        n = grid.length;
        Queue<State> q = new LinkedList<>();
        State s = new State(0,0,1);
        q.add(s);
        boolean[][] seen = new boolean[n][n];
        int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,-1},{1,-1},{-1,1}};
        while(!q.isEmpty()){
            State curr = q.remove();
            if(curr.row==n-1&&curr.col==n-1) {
                return curr.steps;
            }
            for(int[] d: dir){
                int newRow = curr.row+d[0];
                int newCol = curr.col+d[1];
                int steps = curr.steps+1;
                if(valid(newRow,newCol,grid)&&!seen[newRow][newCol]){
                    q.add(new State(newRow,newCol,steps));
                    seen[newRow][newCol]=true;
                }
            }
        }
        return -1;
    }
    public boolean valid(int row, int col, int[][] grid) {
        return 0 <= row && row < n && 0 <= col && col < n && grid[row][col] == 0;
    }
}