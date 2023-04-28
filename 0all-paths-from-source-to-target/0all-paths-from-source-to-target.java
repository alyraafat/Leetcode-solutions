class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        backtrack(curr, ans, 0,graph.length-1,graph);
        return ans;
    }
    
    public void backtrack(List<Integer> curr, List<List<Integer>> ans,int i,int n, int[][] graph) {
        if (i==n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int num: graph[i]) {
            curr.add(num);
            backtrack(curr, ans,num,n, graph);
            curr.remove(curr.size() - 1);     
        }
    }
}