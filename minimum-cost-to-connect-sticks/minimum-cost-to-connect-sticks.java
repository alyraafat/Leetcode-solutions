class Solution {
    public int connectSticks(int[] sticks) {
        int ans = 0;
        if(sticks.length==0) return ans;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int stick: sticks){
            heap.add(stick);
        }
        while(heap.size()>1){
            int s1 = heap.remove();
            int s2 = heap.remove();
            ans+=s1+s2;
            heap.add(s1+s2);
        }
        return ans;
    }
}