class Solution {
    public int partitionString(String s) {
        int ans=0;
        HashSet<Character> set = new HashSet<Character>();
        
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(!set.contains(curr)) set.add(curr);
            else{
                ans+=1;
                set.clear();
                set.add(curr);
            }
        }
        ans+=1;
        return ans;
    }
}