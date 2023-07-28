class Solution {
    int[][][] memo;
    int[] piles;
    public int stoneGameII(int[] piles) {
        memo = new int[piles.length][2*piles.length+1][2];
        for(int i=0;i<memo.length;i++)
            for(int[] arr: memo[i])
                Arrays.fill(arr,-1);
        this.piles=piles;
        return dp(0,1,0);
    }
    public int dp(int i,int m, int turn){
        if(i>=piles.length) return 0;
        if(memo[i][m][turn]!=-1) return memo[i][m][turn];
        int res= turn==0?0:Integer.MAX_VALUE;
        int sum=0;
        for(int j=i;j<Math.min(piles.length,2*m+i);j++){
            sum+=piles[j];
            if(turn==0){ 
                res=Math.max(res,sum+dp(j+1,Math.max(m,j-i+1),1-turn));
            }
            else{
                res=Math.min(res,dp(j+1,Math.max(m,j-i+1),1-turn));
            }
        }
        
        memo[i][m][turn]=res;
        return res;
    }
}