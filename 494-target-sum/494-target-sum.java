class Solution {
    int[] memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo=new int[nums.length];
        // for(int i=0;i<memo.length;i++)
            // Arrays.fill(memo[i],-1);
        Arrays.fill(memo,-1);
        return dp(0,nums,target,0);
    }
    public int dp(int i,int[] nums, int target, int acc){
        if(i==nums.length){
            if(acc==target) return 1;
            else return 0;
        }
        // if(memo[i]!=-1) return memo[i];
        int ways=dp(i+1,nums,target,acc+nums[i])+dp(i+1,nums,target,acc-nums[i]);
        memo[i]=ways;
        return ways;
    }
}