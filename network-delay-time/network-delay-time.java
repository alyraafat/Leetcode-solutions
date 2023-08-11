class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,ArrayList<int[]>> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] time: times){
            map.get(time[0]).add(new int[]{time[1],time[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{k,0});
        HashSet<Integer> seen = new HashSet<>();
        int max=-1;
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            if(seen.contains(curr[0])) continue;
            seen.add(curr[0]);
            max=Math.max(max,curr[1]);
            for(int[] neigh: map.get(curr[0])){
                neigh[1]+=curr[1];
                pq.add(neigh);
            }
        }
        return seen.size()<n?-1:max;
    }
}