class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> counter = new HashMap<Integer,Integer>();
        for(int num: arr){
            counter.put(num,counter.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int key:counter.keySet()){
            heap.add(counter.get(key));
        }
        int n = arr.length/2;
        int ans = 0;
        while(heap.size()>0&&n>0){
            ans++;
            int freq = heap.remove();
            n-=freq;
        }
        return ans;
    }
}