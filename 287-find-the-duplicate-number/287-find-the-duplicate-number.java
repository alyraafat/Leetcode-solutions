class Solution {
    public int findDuplicate(int[] nums) {
        int[] temp = new int[nums.length];
        for(int num:nums){
            if(temp[num]==1) return num;
            temp[num]++;
        }
        return 0;
    }
}