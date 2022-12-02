//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            s.add(nums[i]);
        }
        for(int j=0;j<n+1;j++){
            if(!s.contains(j)) return j;
        }
        return -1;
    }
}
