class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]> weights = new ArrayList<>();
        for(int i=0;i<n;i++){
            int[] p1 = points[i];
            for(int j=i+1;j<n;j++){
                int[] p2 = points[j];
                int dist = Math.abs(p2[0]-p1[0])+Math.abs(p2[1]-p1[1]);
                weights.add(new int[]{i,j,dist});
            }
        }
        Collections.sort(weights,new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               return Integer.compare(a[2],b[2]);
           } 
        });
        UnionFind uf = new UnionFind(n);
        int ans = 0;
        for(int[] arr: weights){
            int before = uf.getCount();
            uf.union(arr[0],arr[1]);
            int after = uf.getCount();
            if(after<before){
                ans+=arr[2];
            }
        }
        return ans;
    }
}
class UnionFind {
    private int[] root;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;
    private int count;

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