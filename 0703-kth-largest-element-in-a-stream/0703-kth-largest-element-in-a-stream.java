class KthLargest {
    int k;
    int[] nums;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.nums=nums;
        pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);
            while(pq.size()>k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        if(pq.size()<k){
            pq.add(val);
        }else if(val>pq.peek()){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */