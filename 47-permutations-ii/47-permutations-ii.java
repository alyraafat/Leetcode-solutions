class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backtrack(new HashSet<>(),ans,nums,new ArrayList<>(),0);
        return ans;
    }
    public void backtrack(HashSet<Integer>set,ArrayList<List<Integer>> ans,int[] nums,ArrayList<Integer> temp,int i){
        if(temp.size()==nums.length){
            ArrayList<Integer> copy = new ArrayList<>(temp);
            if(!ans.contains(copy))ans.add(copy);
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(set.contains(j)){
                continue;    
            }
            set.add(j);
            temp.add(nums[j]);
            backtrack(set,ans,nums,temp,j);
            temp.remove(temp.size()-1);
            set.remove(j);
        }
    }
}