class Solution {
    int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        backtrack(ans,"",n,k);
        int[] ans2 = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ans2[i] = ans.get(i);
        }
        return ans2;
    }
    public void backtrack(List<Integer> ans, String curr, int n, int k){
        if(curr.length()==n){
            int currInt = Integer.parseInt(curr);
            ans.add(currInt);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!curr.equals("")){
                int lastDigit = Integer.parseInt(curr.charAt(curr.length()-1)+"");
                if(Math.abs(nums[i]-lastDigit)==k){
                    backtrack(ans,curr+nums[i],n,k);
                }

            }else {
                if(nums[i]!=0){
                    backtrack(ans,""+nums[i],n,k);
                }
            }
        }
    }
}