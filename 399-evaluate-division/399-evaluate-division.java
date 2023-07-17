class Solution {
    HashMap<String,ArrayList<Pair<String,Double>>> map = new HashMap<>();
    double[] ans;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        ans = new double[queries.size()];
        for(int j=0;j<ans.length;j++){
            ans[j] = -1;
        }
        for(int i=0;i<equations.size();i++){
            List<String> arr = equations.get(i);
            ArrayList<Pair<String,Double>> a = map.getOrDefault(arr.get(0),new ArrayList<>());
            a.add(new Pair<>(arr.get(1),values[i]));
            ArrayList<Pair<String,Double>> a2 = map.getOrDefault(arr.get(1),new ArrayList<>());
            a2.add(new Pair<>(arr.get(0),1.0/values[i]));
            map.put(arr.get(0),a);
            map.put(arr.get(1),a2);
        }
        for(int j=0;j<queries.size();j++){
            List<String> query = queries.get(j);
            if(!map.containsKey(query.get(0))) continue;
            if(map.containsKey(query.get(0))&&query.get(0).equals(query.get(1))) {
                ans[j]=1;
                continue;
            }
            HashSet<String> seen = new HashSet<>();
            seen.add(query.get(0));
            dfs(query.get(0),query.get(1),seen,j,1);
        }
        return ans;
    }
    public void dfs(String curr,String target,HashSet<String> seen, int j,double acc){
        if(!map.containsKey(curr)) return;
        for(Pair<String,Double> p: map.get(curr)){
            if(!seen.contains(p.getKey())){
                seen.add(p.getKey());
                if(p.getKey().equals(target)) {
                    ans[j] = acc*p.getValue();
                    return;
                }
                dfs(p.getKey(),target,seen,j,acc*p.getValue());
            }
        }
    }
}