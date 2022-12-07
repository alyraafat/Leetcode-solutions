//Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.
class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        int max = -1;
        for(int key: nums){
            if(m.get(key)==1 && key>max) max = key; 
        }
        return max;
    }
}
