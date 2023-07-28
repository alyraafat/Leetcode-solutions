class Solution {
    String[] strs;
    // int m;
    // int n;
    int[][][] memo;
    HashMap<Integer,int[]> map = new HashMap<>();
    public int findMaxForm(String[] strs, int m, int n) {
        this.strs=strs;
        // this.m=m;
        // this.n=n;
        memo=new int[strs.length][m+1][n+1];
        // Arrays.fill(memo,-10);
        for(int i=0;i<memo.length;i++){
            for(int[] arr:memo[i]){
                Arrays.fill(arr,-10);
            }
        }
        for(int i=0;i<strs.length;i++){
            map.put(i,getCount(strs[i]));
        }
        return dp(0,m,n);
    }
    public int dp(int i,int m, int n){
        if(m<0||n<0) return -1;
        if(i==strs.length) return 0;
        // if(m==0&&n==0) return 1;
        if(memo[i][m][n]!=-10) return memo[i][m][n];
        int[] curr = map.get(i);
        memo[i][m][n]=Math.max(dp(i+1,m,n),1+dp(i+1,m-curr[0],n-curr[1]));
        return memo[i][m][n];
    }
    public int[] getCount(String s){
        int[] ans = new int[2];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') ans[0]++;
            else ans[1]++;
        }
        return ans;
    }
}