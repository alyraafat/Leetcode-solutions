class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(i==0){
                    dp[i][j] = matrix[i][j];
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                int up = Integer.MAX_VALUE;
                int diagonalLeft = Integer.MAX_VALUE;
                int diagonalRight = Integer.MAX_VALUE;
                if(i-1>=0){
                    up = dp[i-1][j];
                }
                if(i-1>=0&&j-1>=0){
                    diagonalLeft = dp[i-1][j-1];
                }
                if(i-1>=0&&j+1<matrix.length){
                    diagonalRight=dp[i-1][j+1];
                }
                dp[i][j] = matrix[i][j]+ Math.min(diagonalRight,Math.min(up,diagonalLeft));
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<dp[dp.length-1].length;i++){
            result = Math.min(result,dp[dp.length-1][i]);
        }
        return result;
    }
}