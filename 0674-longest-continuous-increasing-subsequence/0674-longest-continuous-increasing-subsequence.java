class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans=1;
        int temp=1;
        for(int j=1;j<nums.length;j++){
            if(nums[j]>nums[j-1]){
                temp++;
            }else{
                ans=Math.max(ans,temp);
                temp=1;
            }
        }
        ans=Math.max(ans,temp);
        return ans;
    }
}