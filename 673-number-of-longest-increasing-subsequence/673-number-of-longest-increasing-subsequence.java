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
            dp(i, nums);
            max = Math.max(len[i], max);
        }
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len[i] == max) {
                x += c[i];
            }
        }
        return x;
    }

    public void dp(int i, int[] nums) {

        if (len[i] != -1) {
            return;
        }
        len[i] = 1;
        c[i]=1;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp(j, nums);
                int x = len[j]+ 1;
                if (x == len[i]) {
                    c[i] += c[j];
                } else if (x > len[i]) {
                    len[i] = x;
                    c[i] = c[j];
                }
            }
        }
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
