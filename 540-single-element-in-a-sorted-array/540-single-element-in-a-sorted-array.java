class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int rem = mid-left;
            if(mid<nums.length-1&&nums[mid]==nums[mid+1]){
                if(rem%2==0){
                    left=mid+2;
                }else{
                    right=mid-1;
                }
            }else if(mid>0&&nums[mid]==nums[mid-1]){
                if(rem%2==0){
                    right=mid-2;
                }else{
                    left=mid+1;
                }
            } else if(!(mid<nums.length-1&&nums[mid]==nums[mid+1])&&!(mid>0&&nums[mid]==nums[mid-1])) {
                return nums[mid];
            }
        }
        return -1;
    }
}