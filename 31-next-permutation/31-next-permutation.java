class Solution {
    public void nextPermutation(int[] nums) {
        boolean desc = false;
        boolean nextLex = false;
        int z = -1;
        for(int i=nums.length-1;i>0;i--){
            int curr = nums[i];
            int prev = nums[i-1];
            if((nums.length-(i-1))<=2&&prev<curr){
                nums[i] = prev;
                nums[i-1] = curr;
                return;
            }
            else if((nums.length-(i-1))>2&&prev<curr){
                nextLex = true;
                z=i-1;
                break;
            }else if(i-1==0&&prev>curr){
                desc = true;
                break;
            }
        }
        if(nextLex){
            int x = nums[z];
            int next = 0;
            int j = -1;
            Arrays.sort(nums,z,nums.length);
            
            for(int i=z;i<nums.length;i++){
                if(nums[i]==x) {
                    if(nums[i+1]==x) continue;
                    next = nums[i+1];
                    j = i+1;
                    break;
                }
            }
            for(int i=j;i>z;i--){
                nums[i] = nums[i-1];
            }
            nums[z] = next;
            
        }else if(desc) {
            Arrays.sort(nums);
        }
    }
}