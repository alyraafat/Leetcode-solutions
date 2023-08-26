class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->{
            return Double.compare(b[2],a[2]);
        });
        for(int[] pt: points){
            double dist = euclidean(pt[0],pt[1]);
            pq.add(new double[]{pt[0],pt[1],dist});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            double[] top = pq.poll();
            ans[i] = new int[]{(int)top[0],(int)top[1]};
            i++;
        }
        return ans;
    }
    public double euclidean(int x, int y){
        return Math.sqrt(x*x+y*y);
    }
}