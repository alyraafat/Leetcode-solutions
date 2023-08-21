class Solution {
    public int mySqrt(int x) {
        return binarySearch(x);
    }
    int binarySearch(int target){
      int left = 0, right = target;
      while(left <= right){
        int mid = left + (right - left) / 2;
          long prod = (long)mid*mid;
        if(prod == target){ return mid; }
        else if(prod < target) { left = mid + 1; }
        else { right = mid - 1; }
      }
      return right;
    }
}