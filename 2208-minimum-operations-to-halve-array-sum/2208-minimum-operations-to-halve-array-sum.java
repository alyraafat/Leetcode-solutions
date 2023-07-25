class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for(int num: nums) {
            pq.add((double)num);
            sum+=num;
        }
        double half=sum/2.0;
        int op=0;
        double acc=0;
        while(acc<half){
            double curr = pq.remove();
            acc+=curr/2.0;
            pq.add(curr/2.0);
            op++;
        }
        return op;
    }
}