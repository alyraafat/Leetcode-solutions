class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick: sticks){
            pq.add(stick);
        }
        int cost = 0;
        while(pq.size()>1){
            int x = pq.poll();
            int y= pq.poll();
            cost+=x+y;
            pq.add(x+y);
        }
        return cost;
    }
}