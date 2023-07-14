class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k, new ArrayList<>(), 1);
        return ans;
    }
    public void backtrack(int n, int k,ArrayList<Integer> temp, int i){
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j=i;j<=n;j++){
            temp.add(j);
            backtrack(n,k,temp,j+1);
            temp.remove(temp.size()-1);
        }
    }
}