// class Solution {
//     HashMap<Integer,ArrayList<Integer>> mapUndirected = new HashMap<>();
//     HashSet<Integer> seen = new HashSet<>();
//     public boolean validTree(int n, int[][] edges) {
//         if(edges.length==0&&n==1) return true;
//         if(edges.length!=n-1) return false;
//         for(int i=0;i<n;i++){
//             mapUndirected.put(i,new ArrayList<>());
//         }
//         for(int[] edge:edges){
//             mapUndirected.get(edge[0]).add(edge[1]);
//             mapUndirected.get(edge[1]).add(edge[0]);
//         }
//         dfs(0);
//         return seen.size()==n;
//     }
//     public void dfs(int i){
//         for(int node: mapUndirected.get(i)){
//             if(!seen.contains(node)){
//                 seen.add(node);
//                 dfs(node);
//             }
//         }
//     }
// }
class Solution{
    public boolean validTree(int n, int[][] edges){
        if(edges.length!=n-1) return false;
        if(edges.length==0&&n==1) return true;
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.getCount()==1;
    }
}
class UnionFind {
    private int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;
    int count;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
                         // a standalone vertex with no connection to other vertices.
        }
    }

	// The find function here is the same as that in the disjoint set with path compression.
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

	// The union function with union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            count--;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
    public int getCount(){
        return count;
    }
}