class Solution {
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    HashSet<Integer> seen = new HashSet<>();
    HashSet<String> seenInput = new HashSet<>();
    int ans=0;
    public int minReorder(int n, int[][] connections) {
        for(int[] conn: connections){
            ArrayList<Integer> arr1 = map.getOrDefault(conn[0],new ArrayList<>());
            arr1.add(conn[1]);
            map.put(conn[0],arr1);
            
            ArrayList<Integer> arr2 = map.getOrDefault(conn[1],new ArrayList<>());
            arr2.add(conn[0]);
            map.put(conn[1],arr2);
            
            seenInput.add(convertToHash(conn[0],conn[1]));
        }
        // System.out.println(map);
        seen.add(0);
        dfs(0);
        return ans;
    }
    public void dfs(int n){
        for(int node: map.get(n)){
            if(!seen.contains(node)){
                if(seenInput.contains(convertToHash(n,node))) ans++;
                seen.add(node);
                dfs(node);
            }
        }
    }
    public String convertToHash(int row, int col) {
        return String.valueOf(row) + "," + String.valueOf(col);
    }
}