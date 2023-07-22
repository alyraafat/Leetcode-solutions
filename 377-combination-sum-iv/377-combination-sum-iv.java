class Solution {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo=new int[target+1];
        Arrays.fill(memo,-1);
        return dp(nums,0,target);
    }
    public int dp(int[] nums,int acc,int target){
        if(acc==target) {
            // System.out.println("equal");
            return 1;
        }
        if(acc>target) return 0;
        if(memo[acc]!=-1){
            return memo[acc];
        }
        int res=0;
        for(int num: nums){
            res+=dp(nums,acc+num,target);
        }
        memo[acc]=res;
        return res;
    }
}