// class Solution {
//     public int findPeakElement(int[] nums) {
//         if(nums.length==1) return 0;
//         return binarySearch(nums);
//     }
//     public int binarySearch(int[] nums){
//         int i=0;
//         int j=nums.length-1;
//         while(i<=j){
//             int mid = (j-i)/2+i;
//             if(mid==nums.length-1&&nums.length>1&&nums[mid]>=nums[mid-1]) return mid;
//             if(mid==0&&nums.length>1&&nums[mid]>=nums[mid+1]) return mid;
//             if(nums[mid]<nums[mid+1]){
//                 i=mid+1;
//             }else if(nums[mid]<nums[mid-1]){
//                 j=mid-1;
//             }else{
//                 return mid;
//             }
//         }
//         return i;
//     }
// }

class Solution{
    public int findPeakElement(int[] nums) {
        return binarySearch(nums);
    }
    int binarySearch(int[] nums){
      if(nums == null || nums.length == 0)
        return -1;
      int left = 0, right = nums.length - 1;
      while(left < right){
          int mid = left + (right - left) / 2;
          if(mid!=nums.length-1&&nums[mid] <nums[mid+1]){ 
              left=mid+1; 
          }
          else if(mid!=0&&nums[mid] < nums[mid-1]) { 
              right = mid; 
          }else {
              return mid;
          }
      }
      return right;
    }
}