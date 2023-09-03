class Solution {
    Integer[][] memo;
    int[] nums;
    int[] multipliers;
    public int maximumScore(int[] nums, int[] multipliers) {
        memo = new Integer[nums.length][multipliers.length];
        this.nums=nums;
        this.multipliers = multipliers;
        return topDown(0,0);
    }
    public int topDown(int i, int j){
        if(j==multipliers.length){
            return 0;
        }
        int k = nums.length-(j-i)-1;
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        memo[i][j] = Math.max(nums[i]*multipliers[j]+topDown(i+1,j+1),nums[k]*multipliers[j]+topDown(i,j+1));
        return memo[i][j];
    }
}