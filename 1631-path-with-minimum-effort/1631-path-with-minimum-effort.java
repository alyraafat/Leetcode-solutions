// class Solution {
//     int m;
//     int n;
//     public int minimumEffortPath(int[][] heights) {
//         int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
//         m = heights.length;
//         n = heights[0].length;
//         boolean[][] seen = new boolean[m][n];
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
//         pq.add(new int[]{0,0,0});
//         int min = Integer.MIN_VALUE;
//         while(!pq.isEmpty()){
//             int[] curr = pq.remove();
//             int i = curr[1];
//             int j = curr[2];
//             if(i==m-1&&j==n-1) return curr[0];
//             if(seen[i][j]) continue;
//             seen[i][j] = true;
//             for(int[] d: directions){
//                 int row = d[0]+i;
//                 int col = d[1]+j;
//                 if(valid(row,col)){
//                     int cost = Math.abs(heights[i][j]-heights[row][col]);
//                     int[] neigh = new int[]{cost,row,col};
//                     if(curr[0]>cost){
//                         pq.add(new int[]{curr[0],row,col});
//                     }else{
//                         pq.add(neigh); 
//                     }
//                 }
//             }
//         }
//         return -1;
//     }
//     public boolean valid(int i, int j){
//         return i>=0&&i<m&&j>=0&&j<n;
//     }
// }

class Solution {
    int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] differenceMatrix = new int[row][col];
        for (int[] eachRow : differenceMatrix)
            Arrays.fill(eachRow, Integer.MAX_VALUE);
        differenceMatrix[0][0] = 0;
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>((a, b) -> (a.difference.compareTo(b.difference)));
        boolean[][] visited = new boolean[row][col];
        queue.add(new Cell(0, 0, differenceMatrix[0][0]));

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            visited[curr.x][curr.y] = true;
            if (curr.x == row - 1 && curr.y == col - 1)
                return curr.difference;
            for (int[] direction : directions) {
                int adjacentX = curr.x + direction[0];
                int adjacentY = curr.y + direction[1];
                if (isValidCell(adjacentX, adjacentY, row, col) && !visited[adjacentX][adjacentY]) {
                    int currentDifference = Math.abs(heights[adjacentX][adjacentY] - heights[curr.x][curr.y]);
                    int maxDifference = Math.max(currentDifference, differenceMatrix[curr.x][curr.y]);
                    if (differenceMatrix[adjacentX][adjacentY] > maxDifference) {
                        differenceMatrix[adjacentX][adjacentY] = maxDifference;
                        queue.add(new Cell(adjacentX, adjacentY, maxDifference));
                    }
                }
            }
        }
        return differenceMatrix[row - 1][col - 1];
    }

    boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }
}

class Cell {
    int x;
    int y;
    Integer difference;

    Cell(int x, int y, Integer difference) {
        this.x = x;
        this.y = y;
        this.difference = difference;
    }
}