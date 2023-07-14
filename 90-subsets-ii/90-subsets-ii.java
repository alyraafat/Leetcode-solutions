class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans.add(new ArrayList<>());
        backtrack(nums,0,new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] nums, int i, ArrayList<Integer> curr){
        for(int j=i;j<nums.length;j++){
            curr.add(nums[j]);
            ArrayList<Integer> copy = new ArrayList<>(curr); 
            Collections.sort(copy);
            if(!ans.contains(copy)) ans.add(copy);
            backtrack(nums,j+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}