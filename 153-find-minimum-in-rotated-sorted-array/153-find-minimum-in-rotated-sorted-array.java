class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int left=0;
        int right=nums.length-1;
        int min = nums[0];
        while(left<=right){
            int mid = left+(right-left)/2;
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            min = Math.min(min,nums[mid]);
            if(nums[mid]>=nums[left]){
                left = mid+1;
            }else if(nums[mid]<=nums[right]){
                right = mid;
            }
        }
        return min ;
    }
}