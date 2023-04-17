class Solution {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
    HashSet<Integer> seen = new HashSet<Integer>();
    HashSet<Integer> res = new HashSet<Integer>();
    int ans = 1;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            int x = edge[0];
            int y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for(int r: restricted){
            res.add(r);
        }
        seen.add(0);
        dfs(0);
        return ans;
    }
    public void dfs(int node){
        for(int n: graph.get(node)){
           if(!seen.contains(n)){
               seen.add(n);
               if(!res.contains(n)) {
                   ans++;
                   dfs(n);
               }               
               
           } 
        }
    }
}