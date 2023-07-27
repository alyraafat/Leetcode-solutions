class Solution {
    int[][] memo;
    int sum;
    public int findTargetSumWays(int[] nums, int target) {
        for(int num: nums){
            sum+=num;
        }
        memo=new int[nums.length][2*sum+1];
        for(int i=0;i<memo.length;i++)
            Arrays.fill(memo[i],-1);
        return dp(0,nums,target,0);
    }
    public int dp(int i,int[] nums, int target, int acc){
        if(i==nums.length){
            if(acc==target) return 1;
            else return 0;
        }
        if(memo[i][sum+acc]!=-1) return memo[i][sum+acc];
        int ways=dp(i+1,nums,target,acc+nums[i])+dp(i+1,nums,target,acc-nums[i]);
        memo[i][sum+acc]=ways;
        return ways;
    }
}