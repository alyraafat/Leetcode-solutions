class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        for(int num:nums){
            heap.add(num);
        }
        while(heap.size()>k){
            heap.remove();
        }
        this.k = k;
    }
    
    public int add(int val) {
        heap.add(val);
        if(heap.size()>k) heap.remove();        
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */