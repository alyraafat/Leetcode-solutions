class Solution {
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int m;
    int n;
    ArrayList<int[]>[][] map;
    boolean[][] seen;
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        map = new ArrayList[m][n];
        seen = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j] = new ArrayList<>();
                for(int[] d: directions){
                    int row = d[0]+i;
                    int col = d[1]+j;
                    if(valid(row,col)){
                        int cost = Math.abs(heights[i][j]-heights[row][col]);
                        map[i][j].add(new int[]{cost,row,col});
                    }
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,0,0});
        int min = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int i = curr[1];
            int j = curr[2];
            if(i==m-1&&j==n-1) return curr[0];
            if(seen[i][j]) continue;
            seen[i][j] = true;
            for(int[] neigh: map[i][j]){
                if(curr[0]>neigh[0]){
                    pq.add(new int[]{curr[0],neigh[1],neigh[2]});
                }else{
                    pq.add(neigh); 
                }
            }
        }
        return -1;
    }
    public boolean valid(int i, int j){
        return i>=0&&i<m&&j>=0&&j<n;
    }
}