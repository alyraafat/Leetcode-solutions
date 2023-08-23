/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left=0;
        int right = (int)Math.pow(10,4)-1;
        int out = (int)Math.pow(2,31)-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int num = reader.get(mid);
            if(num==out){
                right=mid-1;
            }else{
                if(num>target){
                    right=mid-1;
                }else if(num<target){
                    left=mid+1;
                }else{
                    return mid;
                }
            }
        }
        return -1;
    }
}