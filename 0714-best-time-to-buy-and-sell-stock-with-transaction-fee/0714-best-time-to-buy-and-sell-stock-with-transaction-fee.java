// import java.lang.Math;
// class Solution {
//     int[][] memo;
//     int[] prices;
//     public int maxProfit(int[] prices, int fee) {
//         this.prices=prices;
//         int total = 0;
//         for(int i=0;i<prices.length;i++){
//             total+=prices[i];
//         }
//         memo = new int[prices.length][2];
//         for(int[] m: memo)
//             Arrays.fill(m,Integer.MIN_VALUE);
//         topdown(0,0,0,fee,total);
//         int ans = 0;
//         for(int i=0;i<prices.length;i++){
//             ans = Math.max(ans,Math.max(memo[i][0],memo[i][1]));
//         }
//         return ans;
//     }
//     public int topdown(int i, int buy, int total, int fee, int sum){
//         if(i==prices.length) return total;
//         if(memo[i][buy]!=Integer.MIN_VALUE) return memo[i][buy];
//         int x = topdown(i+1,buy,total,fee,sum);
//         if(buy==1){
//             x = Math.max(x,topdown(i+1,1-buy,total+prices[i]-fee,fee,sum));
//         }else{
//             x = Math.max(x,topdown(i+1,1-buy,total-prices[i],fee,sum));
//         }
//         memo[i][buy]=x;
//         return memo[i][buy];
//     }
// }
import java.lang.Math;
import java.util.Arrays;

class Solution {
    int[][] memo;
    int[] prices;
    int fee;

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        this.memo = new int[prices.length][2];
        for (int[] row : memo)
            Arrays.fill(row, -1); 
        return topdown(0, 0);
    }

    public int topdown(int i, int hasStock) {
        if (i == prices.length) return 0; // If no more days are left
        if (memo[i][hasStock] != -1) return memo[i][hasStock]; // Use memoized result

        // No transaction today
        int maxProfit = topdown(i + 1, hasStock);

        if (hasStock == 1) {
            // If we have stock, consider selling it
            maxProfit = Math.max(maxProfit, topdown(i + 1, 0) + prices[i] - fee);
        } else {
            // If we don't have stock, consider buying it
            maxProfit = Math.max(maxProfit, topdown(i + 1, 1) - prices[i]);
        }

        memo[i][hasStock] = maxProfit;
        return memo[i][hasStock];
    }
}
