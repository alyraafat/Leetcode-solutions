class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(nums.length==0){
            ArrayList<Integer> range = new ArrayList<>();
            range.add(lower);
            range.add(upper);
            ans.add(range);
            return ans;
        }else if(nums[0]>lower){
            ArrayList<Integer> range = new ArrayList<>();
            range.add(lower);
            range.add(nums[0]-1);
            ans.add(range);
        }
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1){
                if(nums[i]<upper){
                    ArrayList<Integer> range = new ArrayList<>();
                    range.add(nums[i]+1);
                    range.add(upper);
                    ans.add(range);
                }
            }
            else if(nums[i]!=nums[i+1]-1){
                ArrayList<Integer> range = new ArrayList<>();
                range.add(nums[i]+1);
                range.add(nums[i+1]-1);
                ans.add(range);
            }
        }
        return ans;
    }
}