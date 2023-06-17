class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            int min = Math.min(height[i],height[j]);
            int temp = (j-i)*min;
            if(temp>area) area = temp;
            if(height[i]<=height[j]){
                i++;
            }else {
                j--;
            }
        }
        return area;
    }
}