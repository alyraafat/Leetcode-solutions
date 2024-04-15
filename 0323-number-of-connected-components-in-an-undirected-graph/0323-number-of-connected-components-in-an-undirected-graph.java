import java.util.*;
class Solution {
    HashSet<Integer> seen = new HashSet<>();
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        for(int i=0;i<edges.length;i++){
            ArrayList<Integer> arr1 = map.getOrDefault(edges[i][0], new ArrayList<>());
            arr1.add(edges[i][1]);
            map.put(edges[i][0],arr1);
            ArrayList<Integer> arr2 = map.getOrDefault(edges[i][1], new ArrayList<>());
            arr2.add(edges[i][0]);
            map.put(edges[i][1],arr2);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(!seen.contains(i)){
                ans++;
                dfs(i);
            }
            // System.out.println("in main:"+seen);
        }
        return ans;
    }
    public void dfs(int n){
        seen.add(n);
        // System.out.println("in dfs:"+seen);
        if(map.get(n)==null) return;
        for(int node: map.get(n)){
            if(!seen.contains(node)){
                dfs(node);
            }
        }
    }
}