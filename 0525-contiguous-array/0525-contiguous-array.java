import java.lang.Math;
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int c = 0;
        int len = 0;
        map.put(c,-1);
        for(int i=0;i<nums.length;i++){
            c += nums[i]==1?1:-1;
            if(map.containsKey(c)){
                len = Math.max(len,i-map.get(c));
            }else{
                map.put(c,i);
            }
        }
        return len;
    }
}