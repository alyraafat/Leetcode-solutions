class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int[] ans = new int[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<copy.length;i++){
            if(i>0&&copy[i]==copy[i-1]) continue;
            map.put(copy[i],i);
        }
        for(int j=0;j<nums.length;j++){
            ans[j] = map.get(nums[j]);
        }
        return ans;
    }
}