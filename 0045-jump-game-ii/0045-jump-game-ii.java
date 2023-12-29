class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int curr = nums[0];
        for(int i=1;i<dp.length;i++){
            int res = Integer.MAX_VALUE;;
            for(int j=0;j<i;j++){
                if(nums[j]+j>=i){
                    res = Math.min(res,1+dp[j]);
                }
            }
            dp[i] = res;
        }
        return dp[nums.length-1];
    }
    // public int topdown(int i, int curr){
    //     if(i==nums.length) return 0;
    //     if(memo[i]!=-1) return memo[i];
    //     if(curr==0){
    //         memo[i] = topdown(i+1,nums[i]);
    //     }
    // }
}