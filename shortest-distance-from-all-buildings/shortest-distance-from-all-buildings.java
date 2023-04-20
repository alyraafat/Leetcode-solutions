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
    Queue<State> q = new LinkedList<>();
    int ans;
    HashSet<String> buildingsSeen = new HashSet<String>();
    int buildingsCount = 0;
    public int shortestDistance(int[][] grid) {
        ans = Integer.MAX_VALUE;
        m = grid.length;
        n = grid[0].length;
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    buildingsCount++;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                q.clear();
                buildingsSeen.clear();
                if(grid[i][j]==0){
                    boolean[][] seen = new boolean[m][n];
                    q.add(new State(i,j,0));
                    seen[i][j] = true;
                    int temp =0;
                    while(q.size()!=0){
                        State s = q.remove();
                        int r = s.row;
                        int c = s.col;
                        int steps = s.steps;
                        for(int[] dir: directions){
                            int nextRow = r + dir[0];
                            int nextCol = c + dir[1];
                            if(valid(nextRow,nextCol,grid)&&!seen[nextRow][nextCol]){
                                seen[nextRow][nextCol] = true;
                                if(grid[nextRow][nextCol]==2){
                                    continue;
                                }else if(grid[nextRow][nextCol]==1 && !buildingsSeen.contains(convertToHash(nextRow,nextCol))){
                                    buildingsSeen.add(convertToHash(nextRow,nextCol));
                                    temp+=steps+1;
                                    continue;
                                }else {
                                    q.add(new State(nextRow,nextCol,steps+1));                                   
                                }
                            }
                        }
                        
                    }
                    if(buildingsSeen.size()==buildingsCount&&temp<ans){
                        ans = temp;
                        // System.out.println(i+","+j+": "+temp+", "+buildingsSeen.size());
                        // for(String build: buildingsSeen){
                        //     System.out.print(build+" - ");                            
                        // }
                        // System.out.println();
                        // if(temp<ans) ans=temp;
                    }else if(buildingsSeen.size()<buildingsCount) {
                        for(int k=0;k<m;k++){
                            for(int z=0;z<n;z++){
                                if(seen[k][z]&&grid[k][z]!=1){
                                    grid[k][z] = 2;
                                }
                            } 
                        }
                    }
                 }
                
            }
        }
        
        if(ans==Integer.MAX_VALUE) return -1; 
        return ans;
    }

    public boolean valid(int row, int col, int[][] grid){
        if(row<m && row>=0 && col<n && col>=0){
            return true;
        }
        return false;
    }
    public String convertToHash(int r,int c){
        return r+","+c;
    }
}