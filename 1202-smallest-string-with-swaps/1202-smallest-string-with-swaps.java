class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> pair: pairs){
            uf.union(pair.get(0),pair.get(1));
        }        
        HashMap<Integer,ArrayList<Integer>> rootsToComp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int root = uf.find(i);
            ArrayList<Integer> arr = rootsToComp.getOrDefault(root,new ArrayList<>());
            arr.add(i);
            rootsToComp.put(root,arr);
        }
        char[] ans = new char[s.length()];
        for(int key: rootsToComp.keySet()){
            char[] charArr = new char[rootsToComp.get(key).size()];
            for(int i=0;i<rootsToComp.get(key).size();i++){
                int index = rootsToComp.get(key).get(i);
                charArr[i]=s.charAt(index);
            }
            Arrays.sort(charArr);
            for(int i=0;i<rootsToComp.get(key).size();i++){
                int index = rootsToComp.get(key).get(i);
                ans[index]=charArr[i];
            }
        }
        return new String(ans);
    }
}
class UnionFind {
    private int[] root;
    private int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; 
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

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
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
