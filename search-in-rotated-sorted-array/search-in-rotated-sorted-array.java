class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        if(nums.length==1){
            if(nums[0]==target) return 0;
            else return -1;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[left]==target) return left;
            if(nums[right]==target) return right;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                if(nums[mid]>=nums[left]){
                    if(target>nums[left]){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }else{
                    right=mid-1;
                }
            }else{
                if(nums[mid]<=nums[right]){
                    if(target>nums[right]){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
