class Solution {
    public int splitArray(int[] nums, int k) {
        int left = -1;
        int right = 0;
        for(int num: nums){
            left = Math.max(left, num);
            right+=num;
        }
        while(left<=right){
            int mid = left+(right-left)/2;
            if(check(mid, nums)<=k){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    public int check(int maxSum, int[] nums){
        int splits = 0;
        int sumSoFar = 0;
        for(int i=0;i<nums.length;i++){
            sumSoFar += nums[i];
            if(sumSoFar>maxSum){
                splits++;
                sumSoFar = nums[i];
            }
        }
        return splits+1;
    }
}