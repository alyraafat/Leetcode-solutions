class Solution {
    int[] nums;
    int[][] memo;

    public int rob(int[] nums) {
        this.nums = nums;
        
        // Handle edge case where there's only one house
        if (nums.length == 1) {
            return nums[0];
        }
        
        // Rob houses excluding the last house
        memo = new int[nums.length][2];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        int robFirst = topdown(0, nums.length - 2, 0);

        // Rob houses excluding the first house
        for (int[] arr : memo) Arrays.fill(arr, -1);
        int robLast = topdown(1, nums.length - 1, 0);

        // Return the max of the two scenarios
        return Math.max(robFirst, robLast);
    }

    private int topdown(int i, int end, int prev) {
        if (i > end) return 0;
        if (memo[i][prev] != -1) return memo[i][prev];
        if (prev == 0) {
            memo[i][prev] = Math.max(topdown(i + 1, end, 0), nums[i] + topdown(i + 1, end, 1));
        } else {
            memo[i][prev] = topdown(i + 1, end, 0);
        }
        return memo[i][prev];
    }
}
