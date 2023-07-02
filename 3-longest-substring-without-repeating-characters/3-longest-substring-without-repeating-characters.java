class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        HashSet<Character> set = new HashSet<Character>();
        int j=0;
        int curr = 0;
        
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                curr++;
            }else{
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(j));
                    j++;  
                }
                ans = Math.max(ans,curr);
                set.add(s.charAt(i));
                curr=set.size();   
            }
        }
        ans = Math.max(ans,curr);
        return ans;
    }
}