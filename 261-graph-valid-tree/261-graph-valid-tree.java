class Solution {
    HashMap<Integer,ArrayList<Integer>> mapUndirected = new HashMap<>();
    HashSet<Integer> seen = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length==0&&n==1) return true;
        if(edges.length!=n-1) return false;
        for(int i=0;i<n;i++){
            mapUndirected.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            mapUndirected.get(edge[0]).add(edge[1]);
            mapUndirected.get(edge[1]).add(edge[0]);
        }
        dfs(0);
        return seen.size()==n;
    }
    public void dfs(int i){
        for(int node: mapUndirected.get(i)){
            if(!seen.contains(node)){
                seen.add(node);
                dfs(node);
            }
        }
    }
}