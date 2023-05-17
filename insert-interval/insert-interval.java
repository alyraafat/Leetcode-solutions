class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> ans = new LinkedList<>();
        // if(intervals.length==0) {
        //     ans.add(newInterval);  
        //     return ans.toArray(new int[ans.size()][]);
        // }
        boolean insertFlag = false;
        for (int[] interval: intervals) {
            int start = interval[0], end = interval[1];
            if(!insertFlag){
                if(newInterval[0]<start && newInterval[1]<start){
                    ans.add(newInterval);
                    ans.add(interval);
                    insertFlag = true;
                }
                else if (newInterval[0] <= end && newInterval[1]>=start) {
                    int[] x = new int[]{Math.min(newInterval[0],start),Math.max(newInterval[1],end)};
                    ans.add(x);
                    insertFlag = true;
                }else {
                    ans.add(interval);
                }
            }else {
                if (!ans.isEmpty() && start <= ans.getLast()[1]) {
                    ans.getLast()[1] = Math.max(ans.getLast()[1], end);
                } else {
                    ans.add(interval);
                }
            }
            
        }
        if(!insertFlag){
            ans.add(newInterval);
        }
        
        return ans.toArray(new int[ans.size()][]);
        
    }
}