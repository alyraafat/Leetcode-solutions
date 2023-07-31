class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        int conf=1;
        pq.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            // System.out.println(pq.peek()[0]+","+pq.peek()[1]);
            if(intervals[i][0]<pq.peek()[1]) {
                conf++;
            }else{
                pq.remove();
            }
            pq.add(intervals[i]);
        }
        return conf;
    }
}