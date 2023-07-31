class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int i=0;
        while(i<intervals.length){
            if(ans.size()>0&&intervals[i][0]<=ans.get(ans.size()-1)[1]){
                int[] temp = ans.remove(ans.size()-1);
                ans.add(new int[]{Math.min(temp[0],intervals[i][0]),Math.max(temp[1],intervals[i][1])});
            }else{
                ans.add(intervals[i]);                
            }
            i++;
        }
        int[][] arr = new int[ans.size()][2];
        for(int j=0;j<ans.size();j++){
            arr[j]=ans.get(j);
        }
        return arr;
    }
}