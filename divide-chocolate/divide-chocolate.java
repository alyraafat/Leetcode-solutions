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
            check(mid, sweetness); 
            if(check(mid, sweetness)<=k+1){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        
        return left;
    }
    public int check(int maxSum, int[] sweetness){
        int splits = 0;
        int sumSoFar = 0;
        for(int i=0;i<sweetness.length;i++){
            sumSoFar += sweetness[i];
            if(sumSoFar>maxSum){
                splits++;
                sumSoFar = 0;
            }
        }
 
        return splits+1;
    }
}