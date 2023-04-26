class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for(int num: nums){
            right = Math.max(right,num);
        }
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(check(mid,nums)<=threshold){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    public int check(int k, int[] nums){
        int sum = 0;
        for(int num: nums){
            sum+=Math.ceil((double)(num)/k);
        }
        return sum;
    }
}