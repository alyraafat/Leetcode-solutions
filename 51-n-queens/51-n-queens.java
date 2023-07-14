class Solution {
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> diag = new HashSet<>();
    HashSet<Integer> antidiag = new HashSet<>();
    ArrayList<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append(".");
        } 
        backtrack(n, new ArrayList<>(), 0, sb);
        return ans;
    }
    public void backtrack(int n, ArrayList<String> arr, int i,StringBuilder dots){
        if(arr.size()==n){
            ans.add(new ArrayList<>(arr));
            return;
        }
        // for(int j=i;j<n;j++){
            StringBuilder sb = new StringBuilder(dots);
            for(int k=0;k<n;k++){
                int d = k-i;
                int ad = k+i;
                if(!cols.contains(k)&&!diag.contains(d)&&!antidiag.contains(ad)){
                    cols.add(k);
                    diag.add(d);
                    antidiag.add(ad);
                    sb.replace(k,k+1,"Q");
                    arr.add(sb.toString());
                    backtrack(n,arr,i+1,dots);
                    arr.remove(arr.size()-1);
                    cols.remove(k);
                    diag.remove(d);
                    antidiag.remove(ad);
                    sb.replace(k,k+1,".");
                }
            }
        // }
    }
}