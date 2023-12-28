import java.util.Arrays;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        // Sort the jobs by end time.
        Arrays.sort(jobs, (a, b) -> a.end - b.end);
        
        // Memoization array to store the maximum profit up to the i-th job.
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        
        for (int i = 1; i < n; i++) {
            // Profit if the current job is included.
            int profitIncluding = jobs[i].profit;
            int lastNonConf = findLastNonConflictingJob(jobs,i);
            
            if (lastNonConf != -1) {
                profitIncluding += dp[lastNonConf];
            }
            // Maximum profit up to the i-th job.
            dp[i] = Math.max(profitIncluding, dp[i - 1]);
        }
        
        return dp[n - 1];
    }
    private int findLastNonConflictingJob(Job[] jobs, int i) {
        int low = 0, high = i - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].end <= jobs[i].start) {
                if (jobs[mid + 1].end <= jobs[i].start) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1; // No non-conflicting job found
    }
    class Job {
        int start, end, profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}
