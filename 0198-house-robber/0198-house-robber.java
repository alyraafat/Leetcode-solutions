class Solution {
    int[] nums;
    int[][] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length][2];
        this.nums=nums;
        for(int[] arr: memo) Arrays.fill(arr,-1);
        return topdown(0,0);
    }
    public int topdown(int i,int prev){
        if(i==nums.length) return 0;
        if(memo[i][prev]!=-1) return memo[i][prev];
        if(prev==0){
            memo[i][prev] = Math.max(topdown(i+1,0),nums[i]+topdown(i+1,1));
        }else{
            memo[i][prev] = topdown(i+1,0);
        }
        return memo[i][prev];
        
    }
}