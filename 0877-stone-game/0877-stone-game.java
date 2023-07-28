class Solution {
    Boolean[][] memo;
    public boolean stoneGame(int[] piles) {
        memo=new Boolean[piles.length][piles.length];
        return dp(0,piles.length-1,piles,0,0,0);
    }
    public boolean dp(int i,int j,int[] piles,int alice, int bob,int turn){
        if(i>j) return alice>bob;
        if(memo[i][j]!=null) return memo[i][j];
        if(turn==0){//alice
            memo[i][j]=dp(i+1,j,piles,alice+piles[i],bob,1-turn)||dp(i,j-1,piles,alice+piles[j],bob,1-turn);
        }else{
            memo[i][j]=dp(i+1,j,piles,alice,bob+piles[i],1-turn)||dp(i,j-1,piles,alice,bob+piles[j],1-turn);
        }
        return memo[i][j];
    }
}