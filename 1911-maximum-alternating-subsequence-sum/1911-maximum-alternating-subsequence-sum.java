class Solution {
    long[][] memo;
    public long maxAlternatingSum(int[] nums) {
        memo=new long[nums.length][2];
        for(long[] arr: memo) Arrays.fill(arr,-1);
        return Math.max(dp(0,0,nums),dp(0,1,nums));
    }
    public long dp(int i, int isEven, int[] nums){
        if(i==nums.length) return 0;
        if(memo[i][isEven]!=-1) return memo[i][isEven];
        long sum = dp(i+1,1-isEven,nums);
        sum+=isEven==1?nums[i]:-nums[i];
        memo[i][isEven]=Math.max(dp(i+1,isEven,nums),sum);
        return memo[i][isEven];
    }
}