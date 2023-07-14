class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for(int num:candidates){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        backtrack(target,0,new ArrayList<>());
        return ans;
    }
    public void backtrack(int target,int sum,ArrayList<Integer> curr){
        if(sum==target){
            ArrayList<Integer> copy = new ArrayList<>(curr);
            Collections.sort(copy);
            if(!ans.contains(copy)) ans.add(copy);
            return;
        }
        if(sum>target) return;
        for(int num: map.keySet()){
            int count = map.get(num);
            if(count>0){
                curr.add(num);
                map.put(num,count-1);
                backtrack(target,sum+num,curr);
                curr.remove(curr.size()-1);
                map.put(num,count);
            }
        }
    }
}