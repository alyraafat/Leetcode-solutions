class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        for(int sweet: sweetness){
            left = Math.min(left, sweet);
            right+=sweet;
        }
        while(left<=right){
            int mid = left+(right-left)/2;
            if(check(mid, sweetness)<=k+1){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        
        return right;
    }
    public int check(int minSweet, int[] sweetness){
        int splits = 0;
        int sumSoFar = 0;
        for(int i=0;i<sweetness.length;i++){
            sumSoFar += sweetness[i];
            if(sumSoFar>=minSweet){
                splits++;
                sumSoFar = 0;
            }
        }
 
        return splits+1;
    }
}