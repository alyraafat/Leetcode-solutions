class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean change = false;
        int changed = -1;
        for(int i=0;i<nums.length-1;i++){
            if(!change&&nums[i]>nums[i+1]){
                changed = nums[i];
                nums[i] = nums[i+1];
                change = true;
                if(i>0&&nums[i]<nums[i-1]) {
                    nums[i] = changed;
                    nums[i+1] = nums[i];
                }
            }else if(change&&nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
}