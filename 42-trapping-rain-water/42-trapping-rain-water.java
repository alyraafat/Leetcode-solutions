class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int left = height[i];
            int right = height[j];
            int min = Math.min(left,right);
            if(left<=right){
                i++;
                while(i<j&&height[i]<min){
                    ans+=min-height[i];
                    i++;
                }
            }else{
                j--;
                while(j>i&&height[j]<min){
                    ans+=min-height[j];
                    j--;
                }
            }
        }
        return ans;
    }
}