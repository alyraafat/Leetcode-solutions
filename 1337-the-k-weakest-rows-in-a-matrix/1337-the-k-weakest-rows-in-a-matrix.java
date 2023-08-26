class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(a[1],b[1]);
            }
        });
        for(int i=0;i<mat.length;i++){
            int c = 0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    c++;
                }else{
                    break;
                }
            }
            pq.add(new int[]{i,c});
        }
        int m = mat.length;
        int[] ans = new int[k];
        int i=0;
        while(pq.size()>m-k){
            ans[i]=pq.poll()[0];
            i++;
        }
        return ans;
    }
}