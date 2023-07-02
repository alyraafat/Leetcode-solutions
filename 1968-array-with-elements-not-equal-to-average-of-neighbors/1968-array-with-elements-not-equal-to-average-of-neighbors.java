class Solution {
    public int[] rearrangeArray(int[] nums) {
        for(int i=1;i<nums.length-1;i++){
            double average = (nums[i-1]+nums[i+1])/2.0;
            if(average==nums[i]){
                double av2 = (nums[i-1]+nums[i])/2.0;
                if(av2!=nums[i+1]){
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }else{
                    int temp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                }
                int j=i;
                while(j>1&&((nums[j]+nums[j-2])/2.0==nums[j-1])){
                    av2 = (nums[j]+nums[j-2])/2.0;
                    if(av2==nums[j-1]){
                        int temp = nums[j];
                        nums[j] = nums[j-1];
                        nums[j-1] = temp;
                    }
                    j--;
                    
                }
            }
        }
        return nums;
    }
}