class Solution {
    Boolean[] memo;
    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        // if(nums.length==1) return true;

        return dp(0,nums);
    }
    public boolean dp(int i, int[] nums){
        if(i==nums.length-1) return true;
        if(i>=nums.length||(i<nums.length&&nums[i]==0)) return false;
        if(memo[i]!=null) return memo[i];
        boolean take=false;
        for(int j=1;j<=nums[i];j++){
            take = take||dp(i+j,nums);
        }
        memo[i]=take;
        return take;
    }
}