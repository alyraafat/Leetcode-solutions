class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i,nums.length);
        }
        for(int i=nums.length-1;i>0;i--){
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            maxHeapify(nums,0,i);
        }
        return nums;
    }
    public void maxHeapify(int[] arr,int i, int size){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left<size&&arr[left]>arr[largest]){
            largest=left;
        }
        if(right<size&&arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            maxHeapify(arr,largest,size);
        }
    }
}