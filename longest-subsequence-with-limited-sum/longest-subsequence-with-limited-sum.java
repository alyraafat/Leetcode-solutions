class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(nums);
        int[] prefixSum = new int [nums.length];
        int sum = nums[0];
        int i;
        for(i=1;i<prefixSum.length;i++){
            prefixSum[i-1] = sum;
            sum+=nums[i];
        } 
        prefixSum[i-1] = sum;
        int j=0;
        for(int query: queries){
            int index = binarySearch(prefixSum,query);
            answer[j] = index;
            j++;
        }
        return answer;
    }
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            
            if (num == target) {
                return mid+1;
            }
            
            if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}