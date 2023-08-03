class Solution {
    public void sortColors(int[] nums) {
        // selectionSort(nums);
        countingSort(nums);
    }
    public void selectionSort(int[] nums){
        for(int i=0;i<nums.length;i++){
            int minIndex=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[minIndex]) minIndex=j;
            }
            int temp = nums[minIndex];
            nums[minIndex]= nums[i];
            nums[i]=temp;
        }
    }
    public void countingSort(int[] nums){
        int K = Arrays.stream(nums).max().getAsInt();
        int[] counts=new int[K+1];
        for(int num:nums){
            counts[num]++;
        }
        int startingIndex = 0;
        for(int i=0;i<counts.length;i++){
            int temp=counts[i];
            counts[i]=startingIndex;
            startingIndex+=temp;
        }
        int[] sorted = new int[nums.length];
        for(int num:nums){
            sorted[counts[num]]=num;
            counts[num]++;
        }
        for(int j=0;j<sorted.length;j++) nums[j]=sorted[j];
    }
    
}