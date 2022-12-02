//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = nums[i]*nums[i];
        }
        int x = 0;
        int j = res.length-1;
        while(x<=j){
            if(res[x]>res[j]){
                int temp = res[x];
                res[x] = res[j];
                res[j] = temp;
                j--;
            }else{
                j--;
            }
            if(x==j){
                x++;
                j=res.length-1;
            }
            
        }
        return res;
    }
}
