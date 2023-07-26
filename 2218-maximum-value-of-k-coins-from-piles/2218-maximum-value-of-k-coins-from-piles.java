class Solution {
    int[][] memo;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        memo=new int[piles.size()][k+1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return dp(0,piles,k);
    }
    public int dp(int i,List<List<Integer>> piles, int k){
        if(i==piles.size()||k==0) return 0;
        if(memo[i][k]!=-1) return memo[i][k];
        int max=0;
        int sum = 0;
        for(int j=0;j<Math.min(k,piles.get(i).size());j++){
            sum+=piles.get(i).get(j);
            int take = sum+dp(i+1,piles,k-j-1);
            int skip=dp(i+1,piles,k);
            max=Math.max(max,Math.max(skip,take));   
        }
        memo[i][k]=max;
        return max;
    }
}