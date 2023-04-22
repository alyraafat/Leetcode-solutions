class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int sum = 0;
        for(int pile: piles){
            sum+=pile;
            heap.add(pile);
        }
        for(int i=1;i<=k;i++){
            int curr = heap.remove();
            int newCurr=curr-(curr/2);
            if(curr==0) return sum;
            sum-=curr/2;
            heap.add(newCurr);
        }
        return sum;
    }
}