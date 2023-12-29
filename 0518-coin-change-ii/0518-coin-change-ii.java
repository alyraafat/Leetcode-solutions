class Solution {
    int[][] memo;
    int[] coins;
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount+1];
        for(int[] arr: memo)Arrays.fill(arr,-1);
        this.coins = coins;
        return topdown(0,amount);
    }
    public int topdown(int j,int a){
        if(a==0) return 1;
        if(a<0) return 0;
        if(memo[j][a]!=-1) return memo[j][a];
        int res = 0;
        for(int i=j;i<this.coins.length;i++){
            res += topdown(i,a-this.coins[i]);
        }
        memo[j][a] = res;
        return memo[j][a];
    }
}