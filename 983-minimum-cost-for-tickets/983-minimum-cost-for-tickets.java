class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    HashSet<Integer> daysSet=new HashSet<>();
    int minCost;
    public int mincostTickets(int[] days, int[] costs) {
        minCost = Math.min(costs[0],Math.min(costs[1],costs[2]));
        for(int day: days) daysSet.add(day);
        return dp(days[days.length-1],days,costs);
    }
    public int dp(int curr,int[] days,int[] costs){
        if(curr==days[0]) return minCost;
        if(curr<days[0]) return 0;
        if(memo.containsKey(curr)) return memo.get(curr);
        if(!daysSet.contains(curr)){
            return dp(curr-1,days,costs);
        }
        int one = costs[0]+dp(curr-1,days,costs);
        int seven = costs[1]+dp(curr-7,days,costs);
        int thirty = costs[2]+dp(curr-30,days,costs);
        memo.put(curr,Math.min(one,Math.min(seven,thirty)));
        return memo.get(curr);
    }
}