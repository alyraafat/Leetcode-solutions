class Solution {
    HashSet<Integer> seen = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        seen.add(0);
        return dfs(0,rooms);
    }
    public boolean dfs(int i,List<List<Integer>> rooms){
        for(int key: rooms.get(i)){
            if(!seen.contains(key)){
                seen.add(key);
                dfs(key,rooms);
            }else{
                if(seen.size()==rooms.size()){
                    return true;
                }
            }
        }
        return seen.size()==rooms.size();
    }
}