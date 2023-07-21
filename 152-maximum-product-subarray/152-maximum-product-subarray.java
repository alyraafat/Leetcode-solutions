class Solution {
    public int maxProduct(int[] nums) {
        // int[] dp = new int[nums.length];
        // dp[0]=nums[0];
        // int max=dp[0];
        // for(int i=1;i<nums.length;i++){
        //     int prod = dp[i-1]*nums[i];
        //     if(prod<dp[i-1]){
        //         dp[i] = nums[i];
        //     }else{
        //         dp[i] = prod;
        //     }
        //     max=Math.max(dp[i],max);
        // }
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            int acc=nums[i];
            max=Math.max(max,acc);
            for(int j=i+1;j<nums.length;j++){
                acc*=nums[j];
                max=Math.max(max,acc);
            }
        }
        return max;
    }
}