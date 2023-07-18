class Solution {
    HashMap<Integer,ArrayList<Integer>> mapDirected = new HashMap<>();
    HashMap<Integer,ArrayList<Integer>> mapUndirected = new HashMap<>();
    HashSet<Integer> seen = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length==0&&n==1) return true;
        if(edges.length!=n-1) return false;
        for(int i=0;i<n;i++){
            mapUndirected.put(i,new ArrayList<>());
            mapDirected.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            mapDirected.get(edge[0]).add(edge[1]);
            mapUndirected.get(edge[0]).add(edge[1]);
            mapUndirected.get(edge[1]).add(edge[0]);
        }
        dfs(0);
        if(seen.size()<n) return false;
        seen=new HashSet<>();
        // for(int i=0;i<n;i++){
            // HashSet<Integer> cycle = new HashSet<>();
            // if(!seen.contains(i)){
                // seen.add(0);
                // cycle.add(0);
                // if(isCycle(0,cycle)) return false;
            // }
        // }
        return true;
    }
    public void dfs(int i){
        for(int node: mapUndirected.get(i)){
            if(!seen.contains(node)){
                seen.add(node);
                dfs(node);
            }
        }
    }
    // public boolean isCycle(int i,HashSet<Integer> cycle){
    //     for(int node: mapDirected.get(i)){
    //         if(!seen.contains(node)){
    //             cycle.add(node);
    //             seen.add(node);
    //             if(isCycle(node,cycle)) return true;
    //         }else{
    //             if(cycle.contains(node)) return true;
    //         }
    //     }
    //     return false;
    // }
}