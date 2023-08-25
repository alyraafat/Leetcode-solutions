class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int[] ans = new int[nums.length];
        int[] prod = new int[nums.length];
        prod[nums.length-1] = nums[nums.length-1];
        for(int j=nums.length-2;j>=0;j--){
            prod[j] = nums[j]*prod[j+1];
        }
        for(int i=0;i<nums.length-1;i++){
            ans[i]=left*prod[i+1];
            left*=nums[i];
        }
        ans[nums.length-1] = left;
        return ans;
    }
}