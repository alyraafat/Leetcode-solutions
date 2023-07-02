class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        int ans = 0;
        for(int j=1;j<prices.length;j++){
            if(prices[j]<prices[i]){
                i=j;
            }else if(prices[j]>=prices[i]){
                ans = Math.max(ans,prices[j]-prices[i]);
            }
        }
        return ans;
    }
}