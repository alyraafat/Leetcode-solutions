class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int cov=0;
        int s = intervals[0][0];
        int e = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            // int[] prev = intervals[i-1];
            int[] curr=intervals[i];
            if((curr[0]>=s&&curr[1]<=e)){
                cov++;
            }else if(s==curr[0]&&e<=curr[1]){
                cov++;
                e=curr[1];
            }else{
                s=curr[0];
                e=curr[1];
            }
        }
        return intervals.length-cov;
    }
}