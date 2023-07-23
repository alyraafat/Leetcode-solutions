class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public int numSquares(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        int i=1;
        while(i*i<=n){
            nums.add(i*i);
            i++;
        }
        // System.out.println(nums);
        return dp(n,nums);
    }
    public int dp(int n, ArrayList<Integer> nums){
        if(n==0) return 0;
        if(n<0) return Integer.MAX_VALUE;
        if(memo.containsKey(n)) return memo.get(n);
        int res=Integer.MAX_VALUE;
        for(int num: nums){
            int x = dp(n-num,nums);
            if(x==Integer.MAX_VALUE) continue;
            res=Math.min(res,1+x);
        }
        memo.put(n,res);
        return res;
    }
}