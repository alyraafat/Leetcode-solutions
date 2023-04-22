class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((p1,p2)->{
            double d1 = distance(p1);
            double d2 = distance(p2);
            if(d1<d2) return 1;
            else if(d1>d2) return -1;
            else return 0;
        });
        for(int[] point : points){
            heap.add(point);
            if(heap.size()>k) heap.remove();
        }
        for(int i=0;i<k;i++){
            ans[i] = heap.remove();
        }
        return ans;
        
    }
    public double distance(int[] p){
        int x = p[0];
        int y = p[1];
        return Math.sqrt(x*x+y*y);
    }
}