class Solution {
    public boolean isPerfectSquare(int num) {
        int left=1;
        int right = (int)Math.pow(2,31)-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            long prod = (long)mid*mid;
            if(prod>num){
                right=mid-1;
            }else if(prod<num){
                left=mid+1;
            }else{
                return true;
            }
        }
        return false;
    }
}