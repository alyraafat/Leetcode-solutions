class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // for(int num:candidates){
        //     map.put(num,map.getOrDefault(num,0)+1);
        // }
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new ArrayList<>(),0);
        return ans;
    }
    public void backtrack(int[] candidates,int target,int sum,ArrayList<Integer> curr,int i){
        if(sum==target){
            ArrayList<Integer> copy = new ArrayList<>(curr);
            // Collections.sort(copy);
            // if(!ans.contains(copy)) 
            ans.add(copy);
            return;
        }
        if(sum>target) return;
        // for(int num: map.keySet()){
        //     int count = map.get(num);
        //     if(count>0){
        //         curr.add(num);
        //         map.put(num,count-1);
        //         backtrack(target,sum+num,curr);
        //         curr.remove(curr.size()-1);
        //         map.put(num,count);
        //     }
        // }
        for(int j=i;j<candidates.length;j++){
            if(j>i&&candidates[j]==candidates[j-1]) continue;
            curr.add(candidates[j]);
            sum+=candidates[j];
            backtrack(candidates,target,sum,curr,j+1);
            curr.remove(curr.size()-1);
            sum-=candidates[j];
        }
    }
}