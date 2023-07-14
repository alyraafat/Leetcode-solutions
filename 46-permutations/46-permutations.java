class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backtrack(new HashSet<>(),ans,nums,new ArrayList<>());
        return ans;
    }
    public void backtrack(HashSet<Integer> set,ArrayList<List<Integer>> ans,int[] nums,ArrayList<Integer> temp){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(!set.contains(nums[j])){
                temp.add(nums[j]);
                set.add(nums[j]);
                backtrack(set,ans,nums,temp);
                temp.remove(temp.size()-1);
                set.remove(nums[j]);
            }
        }
    }
}