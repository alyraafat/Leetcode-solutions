class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int half = n/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key: map.keySet()){
            if(map.get(key)>half) return key;
        }
        return -1;
    }
}