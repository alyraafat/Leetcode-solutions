class Solution {
    public int maxNumberOfApples(int[] weight) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        int ans = 0;
        for(int i=0;i<weight.length;i++) {
            heap.add(weight[i]);
        }
        int totalWeight = 5000;
        while(heap.size()>0 && totalWeight>0){
            int currApple = heap.remove();
            if(currApple<=totalWeight){
                totalWeight-= currApple;
                ans++;
            }else {
                break;
            }
            
        }
        return ans;   
    }
}