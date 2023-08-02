class Solution {
    int[][] memo;
    ArrayList<int[]> agesToScore;
    public int bestTeamScore(int[] scores, int[] ages) {
        memo=new int[ages.length][ages.length];
        for(int i=0;i<memo.length;i++)Arrays.fill(memo[i],-1);
        agesToScore = new ArrayList<>();
        for(int i=0;i<ages.length;i++){
            agesToScore.add(new int[]{ages[i],scores[i]});
        }
        Collections.sort(agesToScore,(a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        return dp(0,-1);
    }
    public int dp(int i, int prev){
        if(i==agesToScore.size()) return 0;
        if(memo[i][prev+1]!=-1) return memo[i][prev+1];
        int skip=dp(i+1,prev);
        int take = 0;
        if(prev!=-1){
            if(agesToScore.get(i)[0]==agesToScore.get(prev)[0]||agesToScore.get(i)[1]>=agesToScore.get(prev)[1]){
                take=agesToScore.get(i)[1]+dp(i+1,i);
            }
        }else{
            take=agesToScore.get(i)[1]+dp(i+1,i);
        }
        memo[i][prev+1]=Math.max(skip,take);
        return memo[i][prev+1];
    }
}