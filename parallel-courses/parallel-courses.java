class Solution {
    HashMap<Integer,ArrayList<Integer>> map;
    public int minimumSemesters(int n, int[][] relations) {
        map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        int[] indegree = new int[n+1];
        for(int[] edge: relations){
            map.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> zero = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0) zero.add(i);
        }
        int ans=0;
        int x = 0;
        while(!zero.isEmpty()){
            int size = zero.size();
            x+=size;
            for(int j=0;j<size;j++){
                int curr = zero.remove();
                for(int neigh: map.get(curr)){
                    indegree[neigh]--;
                    if(indegree[neigh]==0) zero.add(neigh);
                }
            }
            ans++;
        }
        return x<n?-1:ans;
    }
    
}