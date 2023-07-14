class Solution {
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> diag = new HashSet<>();
    HashSet<Integer> antidiag = new HashSet<>();
    int ans;
    public int totalNQueens(int n) { 
        backtrack(n, 0);
        return ans;
    }
    public void backtrack(int n, int i){
        if(i==n){
            ans+=1;
            return;
        }
        // StringBuilder sb = new StringBuilder(dots);
        for(int k=0;k<n;k++){
            int d = k-i;
            int ad = k+i;
            if(!cols.contains(k)&&!diag.contains(d)&&!antidiag.contains(ad)){
                cols.add(k);
                diag.add(d);
                antidiag.add(ad);
                backtrack(n,i+1);
                cols.remove(k);
                diag.remove(d);
                antidiag.remove(ad);
            }
        }
    }
}