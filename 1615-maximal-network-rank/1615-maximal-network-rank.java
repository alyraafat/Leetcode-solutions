class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for(int[] road: roads){
            HashSet<Integer> temp1 = map.getOrDefault(road[0],new HashSet<>());
            temp1.add(road[1]);
            map.put(road[0],temp1);
            HashSet<Integer> temp2 = map.getOrDefault(road[1],new HashSet<>());
            temp2.add(road[0]);
            map.put(road[1],temp2);
        }
        int max = 0;
        for(int key: map.keySet()){
            int rank = map.get(key).size();
            for(int x: map.keySet()){
                if(x==key) continue;
                int otherRank = map.get(x).size();
                if(map.get(x).contains(key)) otherRank--;
                max = Math.max(max,rank+otherRank);
            }
        }
        return max;
    }
}