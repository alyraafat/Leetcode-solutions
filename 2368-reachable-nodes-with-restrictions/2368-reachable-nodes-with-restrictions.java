class Solution {
    HashSet<Integer> seen = new HashSet<>();
    HashSet<Integer> res = new HashSet<>();
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    int ans = 1;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for(int r: restricted){
            res.add(r);
        }
        for(int i=0;i<edges.length;i++){
            if(res.contains(edges[i][0]) || res.contains(edges[i][1])){
                continue;
            }
            ArrayList<Integer> arr1 = map.getOrDefault(edges[i][0], new ArrayList<>());
            arr1.add(edges[i][1]);
            map.put(edges[i][0],arr1);
            ArrayList<Integer> arr2 = map.getOrDefault(edges[i][1], new ArrayList<>());
            arr2.add(edges[i][0]);
            map.put(edges[i][1],arr2);
        }
        dfs(0);
        return ans;
    }
    public void dfs(int n){
        seen.add(n);
        // System.out.println("in dfs:"+seen);
        if(map.get(n)==null) return;
        for(int node: map.get(n)){
            if(!seen.contains(node)){
                ans++;
                dfs(node);
            }
        }
    }
}