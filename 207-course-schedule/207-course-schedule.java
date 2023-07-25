class Solution {
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    HashSet<Integer> seen = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            map.get(pre[1]).add(pre[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(seen.contains(i)) continue;
            if(dfs(new HashSet<>(),i)) return false;
        }
        return true;
    }
    public boolean dfs(HashSet<Integer> cycle, int i){
        seen.add(i);
        cycle.add(i);
        for(int node: map.get(i)){
            if(!seen.contains(node)){
                if(dfs(cycle,node)) return true;;
            }else if(cycle.contains(node)) return true;
        }
        cycle.remove(i);
        return false;
    }
}