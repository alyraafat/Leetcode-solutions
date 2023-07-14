class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        backtrack(nums,0,new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] nums, int i, ArrayList<Integer> curr){
        for(int j=i;j<nums.length;j++){
            curr.add(nums[j]);
            ans.add(new ArrayList<>(curr));
            backtrack(nums,j+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}