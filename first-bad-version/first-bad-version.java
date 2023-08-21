/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(n);
    }
    int binarySearch(int target){

      int left = 1, right = target;
      while(left < right){
        int mid = left + (right - left) / 2;
        if(isBadVersion(mid)){ 
            right = mid;
        }
        else { 
            left = mid+1; 
        }
      }
      
      return right;
    }
}