class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i=0;
        int j=0;
        if(k==0) return false;
        HashSet<Integer> set = new HashSet<>();
        while(j<nums.length){
            if(j-i>k){
                set.remove(nums[i]);
                i++;
            }else{
                if(!set.contains(nums[j])){
                    set.add(nums[j]);
                    j++;
                }else{
                    return true;
                }
            }
            
        }
        return false;
    }
}