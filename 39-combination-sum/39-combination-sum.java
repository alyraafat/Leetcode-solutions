class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,0,0,new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] candidates, int target,int i, int sum,ArrayList<Integer> curr){
        if(sum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target) return;
        for(int j=i;j<candidates.length;j++){
            curr.add(candidates[j]);
            sum+=candidates[j];
            backtrack(candidates,target,j,sum,curr);
            curr.remove(curr.size()-1);
            sum-=candidates[j];
        }
    }
}