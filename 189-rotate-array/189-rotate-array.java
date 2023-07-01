class Solution {
    public void rotate(int[] nums, int k) {
        
        int[] a = new int[nums.length];
        int j=0;
        for(;j<nums.length;j++){
            a[(j+k)%nums.length] = nums[j];   
        }
        for (int i = 0; i < nums.length; i++) {
          nums[i] = a[i];
        }
    }
}