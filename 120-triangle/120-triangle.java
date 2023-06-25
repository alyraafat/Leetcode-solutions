class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<List<Integer>> dp = new ArrayList<List<Integer>>();
        dp.add(new ArrayList<>());
        dp.get(0).add(triangle.get(0).get(0));
        for(int i=1;i<triangle.size();i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j=0;j<triangle.get(i).size();j++){
                temp.add(-1);
            }
            dp.add(temp);
        }
        
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                int min = triangle.get(i).get(j);
                if(i-1==0){
                    min+=dp.get(i-1).get(0);
                }else {
                    if(j==0){
                        min += dp.get(i-1).get(j);
                    }else if(j>=dp.get(i-1).size()){
                        min+= dp.get(i-1).get(j-1);
                    }
                    else{
                        min += Math.min(dp.get(i-1).get(j),dp.get(i-1).get(j-1));
                    }    
                }
                
                dp.get(i).set(j,min);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<dp.get(dp.size()-1).size();i++){
            ans = Math.min(ans,dp.get(dp.size()-1).get(i));
        }
        return ans;
    }
}