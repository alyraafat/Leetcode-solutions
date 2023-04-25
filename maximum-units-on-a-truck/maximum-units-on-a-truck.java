class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((b1,b2)->{
            return b2[1]-b1[1];
        });
        int ans = 0;
        for(int i=0;i<boxTypes.length;i++) {
            heap.add(boxTypes[i]);
        }
        while(heap.size()>0 && truckSize>0){
            int[] currBox = heap.remove();
            if(currBox[0]<=truckSize){
                ans+= currBox[0]*currBox[1];
            }else {
                ans+=truckSize*currBox[1];
                break;
            }
            truckSize-=currBox[0];
        }
        return ans;   
    }
}