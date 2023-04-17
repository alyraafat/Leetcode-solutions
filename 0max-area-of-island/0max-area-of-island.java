class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Set<String> seen = new HashSet<>();
    int ans = 0;
    int currArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                currArea = 0;
                String hash = convertToHash(row, col);
                if (grid[row][col] == 1 && !seen.contains(hash)) {
                    currArea++;
                    seen.add(hash);
                    dfs(row, col, grid);
                    if(currArea>ans){
                        ans = currArea;
                        currArea = 0;
                    }
                }
            }
        }
        
        return ans;
    }
    
    public boolean valid(int row, int col, int[][] grid) {
        return 0 <= row && row < m && 0 <= col && col < n && grid[row][col] == 1;
    }
    
    public void dfs(int row, int col, int[][] grid) {
        for (int[] direction: directions) {
            int nextRow = row + direction[0], nextCol = col + direction[1];
            String hash = convertToHash(nextRow, nextCol);
            
            if (valid(nextRow, nextCol, grid) && !seen.contains(hash)) {
                currArea++;
                seen.add(hash);
                dfs(nextRow, nextCol, grid);
            }
        }
    }
    
    public String convertToHash(int row, int col) {
        return String.valueOf(row) + "," + String.valueOf(col);
    }
}