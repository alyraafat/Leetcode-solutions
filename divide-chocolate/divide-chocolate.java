class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        for(int sweet: sweetness){
            left = Math.min(left, sweet);
            right+=sweet;
        }
        int minSweet = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left+(right-left)/2;
            int[] curr = check(mid, sweetness); 
            if(curr[0]<=k+1){
                // minSweet = Math.min(minSweet,curr[1]);
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        
        return left;
    }
    public int[] check(int maxSum, int[] sweetness){
        int splits = 0;
        int sumSoFar = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<sweetness.length;i++){
            sumSoFar += sweetness[i];
            if(sumSoFar>maxSum){
                splits++;
                minSum = Math.min(minSum,sumSoFar);
                // System.out.println(sumSoFar);
                sumSoFar = 0;
            }
        }
        int[] ans = new int[2];
        ans[0] = splits+1;
        ans[1] = minSum;
        return ans;
    }
}