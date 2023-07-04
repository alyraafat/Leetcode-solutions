class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<=2) return false;
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{nums[0],nums[0]});
        int min = nums[0];
        for(int k=1;k<nums.length;k++){
            int numK = nums[k];
            while(!st.isEmpty()&&st.peek()[0]<=numK){
                st.pop();
            }
            if(!st.isEmpty()&&numK>st.peek()[1]) return true;
            st.push(new int[]{numK,min});
            min = Math.min(min,numK);
        }
        return false;
    }
}