class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0){
            maxHeap.add(num);
        } else if(minHeap.size()==maxHeap.size()){
            if(num<minHeap.peek()){
                maxHeap.add(num);
            }else{
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        }else{//maxHeap>minHeap
            if(num<maxHeap.peek()){
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }else{
                minHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        int size = minHeap.size()+maxHeap.size();
        if(size%2==0){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */