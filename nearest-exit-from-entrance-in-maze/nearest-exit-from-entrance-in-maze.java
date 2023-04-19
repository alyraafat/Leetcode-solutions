class State {
    int row;
    int col;
    int steps;
    public State(int row,int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        Queue<State> q = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        q.add(new State(entrance[0],entrance[1],0));
        seen[entrance[0]][entrance[1]] = true;
        while(q.size()!=0){
            State s = q.remove();
            int r = s.row;
            int c = s.col;
            int steps = s.steps;
            for(int[] dir: directions){
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];
                if(valid(nextRow,nextCol,maze)&&!seen[nextRow][nextCol]){
                    seen[nextRow][nextCol] = true;
                    q.add(new State(nextRow,nextCol,steps+1));
                    if(isExit(nextRow,nextCol,entrance)) return steps+1;
                }
            }
        }
        return -1;
    }
    
    public boolean valid(int row, int col, char[][] maze){
        if(row<m && row>=0 && col<n && col>=0 && maze[row][col]=='.'){
            return true;
        }
        return false;
    }
    
    public boolean isExit(int row, int col, int[] entrance){
        if((row==m-1 || col==n-1|| row==0 || col==0) && (row!=entrance[0] || col!=entrance[1])){
            return true;
        }
        return false;
    }
}