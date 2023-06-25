class Pair{
    int key;
    int freq;
    public Pair(int key, int freq){
        this.key = key;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return b.freq-a.freq;
        });
        for(int key: map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }
        for(int i=0;i<k;i++){
            ans[i] = (pq.poll()).key;
        }
        return ans;
    }
}