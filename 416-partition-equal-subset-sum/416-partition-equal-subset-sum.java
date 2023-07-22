class Solution {
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2==1) return false;
        memo = new int[nums.length][sum/2 +1];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return dp(0,nums,0,sum/2);
    }
    public boolean dp(int i, int[] nums, int acc, int half){
        if(acc==half) return true;
        if(acc>half||i==nums.length) return false;
        if(memo[i][acc]!=-1) return memo[i][acc]==1;
        boolean ignore = dp(i+1,nums,acc,half);
        boolean notIgnore = dp(i+1,nums,acc+nums[i],half); 
        memo[i][acc]=(notIgnore || ignore)?1:0;
        return memo[i][acc]==1;
    }
}