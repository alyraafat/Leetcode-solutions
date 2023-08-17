class Solution {
    HashMap<Integer,HashSet<Integer>> map;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashSet<>());
        }
        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return bfs(n);
    }
    public List<Integer> bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            if(map.get(i).size()==1) {
                q.add(i);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int k = n;
        while(!q.isEmpty()&&k>2){
            int size= q.size();
            for(int j=0;j<size;j++){
                int curr = q.poll();
                arr.add(curr);
                k--;
                for(int child : map.get(curr)){
                    map.get(child).remove(curr);
                    if(map.get(child).size()==1) q.add(child);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        return ans;
    }
}