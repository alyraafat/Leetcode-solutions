class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<manager.length;i++){
            if(manager[i]!=-1)
                map.get(manager[i]).add(i);
        }
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(headID,0));
        int total = 0;
        while(!q.isEmpty()){
            int size=q.size();
            // int max = 0;
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> pair = q.remove();
                int id = pair.getKey();
                int time = pair.getValue();
                ArrayList<Integer> arr = map.get(id);
                for(int j=0;j<arr.size();j++){
                    q.add(new Pair<>(arr.get(j),informTime[id]+time));
                }
                total=Math.max(total,informTime[id]+time);
            }
            // total=max;
        }
        return total;
    }
}