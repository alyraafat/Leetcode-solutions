class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(target<=0&&nums[0]>0) return ans;
        HashSet<ArrayList<Integer>> unique = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            int sum = nums[i];
            int j = i+1;
            for(;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                temp.add(nums[j]);
                sum +=nums[j];
                int x = j+1;
                int z = nums.length-1;
                sum+= nums[x]+nums[z];
                while(x<z){
                    if(sum>target){
                        sum-=nums[z];
                        z--;
                        sum+=nums[z];
                    }else if(sum<target){
                        sum-=nums[x];
                        x++;
                        sum+=nums[x];
                    }else{
                        temp.add(nums[x]);
                        temp.add(nums[z]);
                        ArrayList<Integer> copy = (ArrayList)temp.clone();
                        if(!unique.contains(copy)) {
                            ans.add(copy);
                            unique.add(copy);
                        }
                        sum-=nums[x]+nums[z];
                        x++;
                        z--;
                        temp.remove(temp.size()-1);
                        temp.remove(temp.size()-1);
                        sum+= nums[x]+nums[z];
                    }
                }
                sum=nums[i];
                temp.clear();
                temp.add(nums[i]);
            }
            
        }
        return ans;
    }
}