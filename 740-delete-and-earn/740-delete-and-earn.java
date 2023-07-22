class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
            max=Math.max(max,num);
        }
        
        return dp(max);
    }
    public int dp(int max){
        if(max==0) return 0;
        if(max==1) return map.getOrDefault(1,0);
        if(memo.containsKey(max)){
            return memo.get(max);
        }
        if(map.containsKey(max)){
            memo.put(max,Math.max(dp(max-1),dp(max-2)+max*map.get(max)));
        }else{
            memo.put(max,Math.max(dp(max-1),dp(max-2)));  
        }
        return memo.get(max);
        
    }
}