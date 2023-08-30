class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int i=0;
        int j= nums.length-1;
        while(i<j){
            int mid = i+(j-i)/2;
            if(nums[mid]>nums[j]){
                i = mid+1;
            }else if(nums[mid]<nums[j]){
                if(nums[mid]<nums[i]){
                    j=mid;
                }else{
                    j=mid-1;
                }
            }else{
                if(nums[i]<nums[mid]){
                    j=mid-1;
                }else if(nums[mid]==nums[i]){
                    j--;
                }else{
                    i++;
                }
            }
        }
        return nums[i];
    }
}