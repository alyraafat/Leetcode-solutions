class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {-1,-1};
        ans[0] = getEnds(nums,target, true);
        ans[1] = getEnds(nums,target, false);
        return ans;
    }
    public int getEnds(int[] nums, int target, boolean start){
        int first = 0;
        int last = nums.length-1;
        int ans = -1;
        while(first<=last){
            int mid = (first-last)/2 +last;
            if(target==nums[mid]){
                if(start){
                    if(ans==-1||ans>mid) ans=mid;
                    last = mid-1;  
                }else {
                    if(ans==-1||ans<mid) ans=mid;
                    first = mid+1;
                }
                
            }else if(target<nums[mid]){
                last = mid-1;
            }else {
                first = mid+1;
            }
        }
        return ans;
    }
}