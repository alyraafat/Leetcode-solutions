class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
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

}