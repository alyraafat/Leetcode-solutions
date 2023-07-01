class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int start = -1;
        for(int i=0;i<nums.length;i++){
            if(start==-1&&nums[i]==0) start = i;
            else if(start!=-1&&nums[i]!=0){
                for(int j=0;j<(i-start);j++){
                    ans+=i-start-j;
                }
                start=-1;
            }
        }
        if(start!=-1){
                for(int j=0;j<(nums.length-start);j++){
                    ans+=nums.length-start-j;
                }
                start=-1;
        }
        return ans;
    }
}