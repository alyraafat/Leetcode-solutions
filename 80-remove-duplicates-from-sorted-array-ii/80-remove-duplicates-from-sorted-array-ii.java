class Solution {
    public int removeDuplicates(int[] nums) {
        int swap = 1;
        int count = 1;
        int k = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[swap]=nums[i];
                swap++;
                k++;
                count = 1;
            }else if(count<2&&nums[i]==nums[i-1]){
                nums[swap]=nums[i];
                swap++;
                count++;
                k++;
            }else if(nums[i]==nums[i-1]) {
                count++; 
            } 
        }
        return k;
    }
}