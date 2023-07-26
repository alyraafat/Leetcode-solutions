class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        return binarySearch(nums);
    }
    public int binarySearch(int[] nums){
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid = (j-i)/2+i;
            if(mid==nums.length-1&&nums.length>1&&nums[mid]>=nums[mid-1]) return mid;
            if(mid==0&&nums.length>1&&nums[mid]>=nums[mid+1]) return mid;
            if(nums[mid]<nums[mid+1]){
                i=mid+1;
            }else if(nums[mid]<nums[mid-1]){
                j=mid-1;
            }else{
                return mid;
            }
        }
        return i;
    }
}