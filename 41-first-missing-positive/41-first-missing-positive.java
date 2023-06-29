class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            if(num>0){
                len+=1;
                max = Math.max(max,num);
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
        // for(int i=1;i<=len;i++){
        //     boolean found = false;
        //     for(int num:nums){
        //         if(num==i){
        //             found=true;
        //             break;
        //         }
        //     }
        //     if(!found) return i;
        // }
        // return -1;
    }
}