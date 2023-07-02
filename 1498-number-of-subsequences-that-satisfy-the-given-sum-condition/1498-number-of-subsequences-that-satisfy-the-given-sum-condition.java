class Solution {
    public int numSubseq(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        int x=0;
        int z=nums.length-1;
        while(z>=0){
            if(nums[z]>target) z--;
            else break;
        }
        int num = 1_000_000_007;
        while(x<=z){
            if(nums[x]+nums[z]<=target){
                ans=(int)((ans + quickPow(2, z - x)) % num);
                x++;
            }else{
                z--;
            }
        }
        return ans;
    }
      private long quickPow(int x, int n){
        int MOD = 1_000_000_007;

        if (n == 0) {
            return 1;
        }

        long t = x;

        long res = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * t) % MOD;
            }

            t = (t * t) % MOD;
            n >>= 1;
        }

        return res % MOD;
    }
}