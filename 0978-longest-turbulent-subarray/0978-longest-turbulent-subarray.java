class Solution {
    int[][] memo;
    public int maxTurbulenceSize(int[] arr) {
        memo = new int[arr.length][2];
        memo[arr.length-1][0] = 1;
        memo[arr.length-1][1] = 1;
        int max = 1;
        for(int i=0;i<arr.length-1;i++){
            max = Math.max(max,Math.max(dp(i,0,arr),dp(i,1,arr)));
        }
        return max;
    }
    public int dp(int i , int isEven, int[] arr){
        if(i==arr.length){
            return 0;
        }
        if(memo[i][isEven]!=0) return memo[i][isEven];
        if(i<arr.length-1){
            if(isEven==1){
                if(arr[i]>arr[i+1]){
                    memo[i][isEven] = Math.max(memo[i][isEven],1+dp(i+1,1-isEven,arr));
                }else{
                    memo[i][isEven]=1;
                }
            }else{
                if(arr[i]<arr[i+1]){
                    memo[i][isEven] = Math.max(memo[i][isEven],1+dp(i+1,1-isEven,arr));
                }else{
                    memo[i][isEven]=1;
                }
            }
        }
        return memo[i][isEven];
    }
}