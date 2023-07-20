class Solution {
    HashMap<Integer,Long> memo = new HashMap<>();
    public long mostPoints(int[][] questions) {
        // memo.put(questions.length-1,(long)questions[questions.length-1][0]);
        return dp(0,questions);
    }
    public long dp(int i,int[][] questions){
        if(i<0||i>=questions.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        long take = dp(questions[i][1]+i+1,questions)+questions[i][0];
        long notTake = dp(i+1,questions);
        long ans = Math.max(take,notTake);
        memo.put(i,ans);
        return ans;
    }
}