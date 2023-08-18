class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        int[] avgs = new int[nums.length];
        long[] prefixSum = new long[nums.length+1];
        for(int i=1;i<=nums.length;i++){
            avgs[i-1]=-1;
            prefixSum[i]=prefixSum[i-1]+nums[i-1];
        }
        for(int i=k;i<nums.length-k;i++){
            long start = prefixSum[i-k];
            long end = prefixSum[i+1+k];
            long avg = (end-start)/(2*k+1);
            avgs[i] =(int) avg;
        }
        return avgs;
    }
}