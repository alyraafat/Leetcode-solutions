class State{
    int row;
    int col;
    int steps;
    public State(int row, int col, int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<State> q = new LinkedList<>();
        boolean fresh = false;
        int countFresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=1){
                    seen[i][j] = true;
                    if(grid[i][j]==2) q.add(new State(i,j,0));
                }else{
                    fresh=true;
                    countFresh++;
                }
            }
        }
        if(!fresh) return 0;
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean changed = false;
            for(int i=0;i<size;i++){
                State curr=q.remove();
                for(int[] d: directions){
                    int newRow = d[0]+curr.row;
                    int newCol = d[1]+curr.col;
                    if(valid(newRow,newCol,m,n)&&!seen[newRow][newCol]){
                        seen[newRow][newCol]=true;
                        q.add(new State(newRow,newCol,curr.steps+1));
                        grid[newRow][newCol]=2;
                        changed=true;
                        countFresh--;
                    }
                }
            }
            if(changed)ans++;
        }
        return ans==0?-1:(countFresh==0?ans:-1);
    }
    public boolean valid(int row,int col,int m,int n){
        return row>=0&&row<m&&col>=0&&col<n;
    }
}