// class Solution {
//     int[][] memo;
//     public int minCost(int n, int[] cuts) {
//         // Arrays.sort(cuts);
//         memo=new int[n+1][n+1];
//         for(int i=0;i<memo.length;i++){
//             for(int j=0;j<memo[i].length;j++){
//                 memo[i][j]=-1;
//             }
//         }
//         return cost(cuts,0,n);
//     }
//     public int cost(int[] cuts,int l, int r){
//         if(r-l<=1) return 0;
//         if(memo[l][r]!=-1) return memo[l][r];
//         int c = Integer.MAX_VALUE;
//         for(int j=0;j<cuts.length;j++){
//             if(!(cuts[j]>l&&cuts[j]<r)) continue;
//             int c1 = r-l+cost(cuts,l,cuts[j])+cost(cuts,cuts[j],r);
//             c=Math.min(c,c1);
//         }
//         memo[l][r]= c==Integer.MAX_VALUE?0:c;
//         return memo[l][r];
//     }
// }
class Solution {
    int[][] memo;
    int newCuts[];
    private int cost(int left, int right) {
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        if (right - left == 1) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int mid = left + 1; mid < right; mid++) {
            int cost = cost(left, mid) + cost(mid, right) + newCuts[right] - newCuts[left];
            ans = Math.min(ans, cost);
        }
        memo[left][right] = ans;
        return ans;
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        Arrays.sort(newCuts);
        
        memo = new int[m + 2][m + 2];
        for (int r = 0; r < m + 2; ++r) {
            Arrays.fill(memo[r], -1);
        }
        
        return cost(0, newCuts.length - 1);
    }    
}



