class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(nums[0]>0||nums[nums.length-1]<0) return ans;
        HashMap<Integer,HashSet<Integer>> temp = new HashMap<>();
        HashSet<ArrayList<Integer>> seen = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            HashSet<Integer> set = temp.getOrDefault(nums[i],new HashSet<>());
            set.add(i);
            temp.put(nums[i],set);
        }
        int i=0;
        int j=nums.length-1;
        int sumSoFar = 0;
        if(temp.containsKey(0)&&temp.get(0).size()>=3){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(0);
            arr.add(0);
            arr.add(0);
            ans.add(arr);
        }
        for(i=0;i<nums.length-1;i++){
            int x = nums[i];
            if(x==nums[i+1]) continue;
            for(j=nums.length-1;j>i;j--){
                int y = nums[j];
                sumSoFar=x+y;
                ArrayList<Integer> arr = new ArrayList<>();
                int diff = 0-sumSoFar;
                HashSet<Integer> diffSet = temp.get(diff);
                // System.out.println(x+","+y+","+diff+","+diffSet);
                if(temp.containsKey(diff)){
                    if(diff!=x&&diff!=y){
                        arr.add(x);
                        arr.add(y);
                        arr.add(diff);
                    }else if(diff==x||diff==y){
                        if(diff==x&&diff==y){
                            if(diffSet.size()>=3){
                                arr.add(x);
                                arr.add(y);
                                arr.add(diff);
                            }
                        }else {
                            if(diffSet.size()>=2){
                                arr.add(x);
                                arr.add(y);
                                arr.add(diff);
                            }
                        }
                    }
                    Collections.sort(arr);
                    if(arr.size()==3&&!seen.contains(arr)){
                        seen.add(arr);
                    }
                }
            } 
        }

        for(ArrayList<Integer> arr: seen){
            ans.add(arr);
        }

        return ans;
    }
}