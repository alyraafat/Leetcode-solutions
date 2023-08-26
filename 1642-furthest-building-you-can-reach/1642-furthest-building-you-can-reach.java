class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        for(;i<heights.length-1;i++){
            if(heights[i]<heights[i+1]){
                int diff = heights[i+1]-heights[i];
                if(ladders>0){
                    pq.add(diff);
                    ladders--;
                }else{
                    if(!pq.isEmpty()&&diff>pq.peek()){
                        pq.add(diff);
                        int s = pq.poll();
                        if(bricks>=s){
                            bricks-=s;
                        }else{
                            return i;
                        }
                    }else{
                        if(bricks>=diff){
                            bricks-=diff;
                        }else{
                            return i;
                        }
                    }
                }
            }
        }
        return i;
    }
}