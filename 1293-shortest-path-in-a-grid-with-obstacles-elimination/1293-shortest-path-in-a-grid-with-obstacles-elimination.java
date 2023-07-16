class State {
    int row;
    int col;
    int remain;
    int steps;
    State(int row, int col, int remain, int steps) {
        this.row = row;
        this.col = col;
        this.remain = remain;
        this.steps = steps;
    }
}
class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int shortestPath(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        Queue<State> q = new LinkedList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        boolean[][][] seen = new boolean[m][n][k+1];
        int rem = k;
        if(grid[0][0]==1) rem--;
        seen[0][0][rem] = true;
        q.add(new State(0,0,rem,0));
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                State curr = q.remove();
                if(curr.row==m-1&&curr.col==n-1) return curr.steps;
                for(int[] d: directions){
                    int row = curr.row+d[0];
                    int col = curr.col+d[1];
                    int steps = curr.steps+1;
                    int remain = curr.remain;
                    State s1 = new State(row,col,remain,steps);
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(row);
                    arr.add(col);
                    arr.add(remain);
                    if(valid(row,col,remain,grid)){
                        if(grid[row][col]==0&&!set.contains(arr)){
                            set.add(arr);
                            // seen[row][col]=true;
                            q.add(s1);
                        }else if(grid[row][col]==1&&s1.remain>0){
                            s1.remain--;
                            arr.set(2,arr.get(2)-1);
                            if(!set.contains(arr)){
                                set.add(arr);
                                q.add(s1);
                            } 
                        }
                    }
                }
            }
        }
        return -1;
    }
    public boolean valid(int row,int col, int remain,int[][] grid){
        return row>=0&&row<m&&col>=0&&col<n;
    }
}