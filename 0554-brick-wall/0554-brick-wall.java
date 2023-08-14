class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Double,Integer> map = new HashMap<>();
        for(int i=0;i<wall.size();i++){
            int sum=0;
            for(int j=0;j<wall.get(i).size();j++){
                sum+=wall.get(i).get(j);
                map.put(sum+0.5,map.getOrDefault(sum+0.5,0)+1);
            }
            map.remove(sum+0.5);
        }
        int max = 0;
        for(double key:map.keySet()){
            max=Math.max(max,map.get(key));
        }
        return wall.size()-max;
    }
}