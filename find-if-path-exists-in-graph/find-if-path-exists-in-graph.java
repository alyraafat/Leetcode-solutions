class Solution {
    HashMap<Integer,ArrayList<Integer>> graph = new HashMap<Integer,ArrayList<Integer>>();
    HashSet<Integer> seen = new HashSet<Integer>();
    boolean flag = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            int x = edge[0], y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        // for(int key : graph.keySet()){
        //     System.out.print(key+":");
        //     toString(graph.get(key));
        // }
        // System.out.println("-----------------");
        seen.add(source);
        dfs(source,destination,graph);
        return flag;
    }
    public void dfs(int node,int dest,HashMap<Integer,ArrayList<Integer>> graph){
        if(node==dest) {
            flag= true;
            return;
        }
        for(int neighbor : graph.get(node)){
            
            if(!seen.contains(neighbor)){
                if(neighbor==dest) {
                    flag = true;
                    return;
                }
                seen.add(neighbor);
                dfs(neighbor,dest,graph);
            }
        }
        
    }
    public void toString(ArrayList<Integer> arr) {  
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+",");
        }
        System.out.println();
    }
}