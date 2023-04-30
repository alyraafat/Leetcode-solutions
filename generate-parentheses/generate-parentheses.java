class Solution {
    public List<String> generateParenthesis(int n) {
        String brackets = "";
        for(int i=0;i<n;i++){
            brackets+="()";
        }
        List<String> ans = new ArrayList<String>();
        backtrack("", ans, n,0,0);
        return ans;
    }
    public void backtrack(String curr, List<String> ans, int n, int left,int right){
         if(curr.length()==2*n) {
            ans.add(new String(curr));
            return;
        }
        if(left<n){
            backtrack(curr+'(',ans,n,left+1,right);   
        }
        if(right<left){
            backtrack(curr+')',ans,n,left,right+1);
        }
    }
   
}