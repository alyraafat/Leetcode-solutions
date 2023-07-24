import java.util.Arrays;

class Solution {
    int[] len;
    int[] c;

    public int findNumberOfLIS(int[] nums) {
        len = new int[nums.length];
        Arrays.fill(len, -1);
        c = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(dp(i, nums), max);
        }
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len[i] == max) {
                x += countLIS(i, nums);
            }
        }
        return x;
    }

    public int dp(int i, int[] nums) {
        if (i == nums.length) {
            return 0;
        }
        if (len[i] != -1) {
            return len[i];
        }
        len[i] = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                int x = dp(j, nums) + 1;
                if (x == len[i]) {
                    c[i] += c[j];
                } else if (x > len[i]) {
                    len[i] = x;
                    c[i] = c[j];
                }
            }
        }
        return len[i];
    }

    public int countLIS(int i, int[] nums) {
        if (i == nums.length || len[i] == 1) {
            return 1;
        }
        if (c[i] > 0) {
            return c[i];
        }
        int count = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i] && len[j] == len[i] - 1) {
                count += countLIS(j, nums);
            }
        }
        c[i] = count;
        return count;
    }
}
