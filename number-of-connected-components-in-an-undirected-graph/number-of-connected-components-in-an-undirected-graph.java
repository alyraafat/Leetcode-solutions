class Solution {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
    HashSet<Integer> seen = new HashSet<Integer>();
    int ans = 0;
    public int countComponents(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            int x = edge[0];
            int y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for(int i=0;i<n;i++){
            if(!seen.contains(i)){
                seen.add(i);
                dfs(i);
                ans++;
            }
            
        }
        return ans;
    }
    public void dfs(int node){
        for(int n: graph.get(node)){
            if(!seen.contains(n)){
                seen.add(n);
                dfs(n);
            }
        }
    }
}