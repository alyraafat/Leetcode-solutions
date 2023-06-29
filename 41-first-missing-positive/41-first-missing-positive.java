class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = 0;
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            if(num>0){
                len+=1;
                min = Math.min(min,num);
            }
        }
        if(min>1) return 1;
        boolean[] temp = new boolean[len+1];
        for(int num:nums){
            if(num>0&&num<len+1){
                temp[num]=true;;
            }
        }
        int ans = 0;
        for(int i=1;i<temp.length;i++){
            if(!temp[i]){
                ans=i;
                break;
            }
        }
        if(ans==0) ans = temp.length;
        return ans;
    }
}