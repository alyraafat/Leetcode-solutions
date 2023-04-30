class Solution {
    int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtrack(ans,new ArrayList<Integer>(),0,0,n,k);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans, List<Integer> curr,int j,int sumSoFar, int n, int k){
        if(curr.size()==k&&sumSoFar==n){
            ans.add(new ArrayList(curr));
            return;
        }
        for(int i=j;i<nums.length;i++){
            sumSoFar+=nums[i];
            if(sumSoFar>n){
                return;
            }
            curr.add(nums[i]);
            backtrack(ans,curr,i+1,sumSoFar,n,k);
            sumSoFar-=nums[i];
            curr.remove(curr.size()-1);
        }
    }
}