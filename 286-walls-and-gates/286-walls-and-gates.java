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
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        boolean[][] seen = new boolean[m][n];
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        Queue<State> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]!=Integer.MAX_VALUE){
                    seen[i][j] = true;
                    if(rooms[i][j]==0) q.add(new State(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                State curr=q.remove();
                for(int[] d: directions){
                    int newRow = d[0]+curr.row;
                    int newCol = d[1]+curr.col;
                    if(valid(newRow,newCol,m,n)&&!seen[newRow][newCol]){
                        seen[newRow][newCol]=true;
                        q.add(new State(newRow,newCol,curr.steps+1));
                        rooms[newRow][newCol]=curr.steps+1;
                    }
                }
            }
        }
    }
    public boolean valid(int row,int col,int m,int n){
        return row>=0&&row<m&&col>=0&&col<n;
    }
}