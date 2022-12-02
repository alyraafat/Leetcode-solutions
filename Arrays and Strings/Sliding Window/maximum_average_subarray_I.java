//You are given an integer array nums consisting of n elements, and an integer k.
//Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double curr = 0.0;
        for (int i = 0; i < k; i++) {
            curr += nums[i];
        }

        double ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
        }
        ans/=(double)k;

        return ans;
    }
}
