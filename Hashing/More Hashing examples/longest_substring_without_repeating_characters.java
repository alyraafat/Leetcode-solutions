//Given a string s, find the length of the longest substring without repeating characters.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String,List<Integer>> m = new HashMap<String,List<Integer>>();
        int l = 0;
        int r = 0;
        int ans = Integer.MIN_VALUE;
        int far = 0;
        HashSet<Character> sofar = new HashSet<Character>();           
        while(l<=r &&l<s.length()&&r<s.length()){
            char x = s.charAt(l);
            char y = s.charAt(r);
           // System.out.println(sofar.contains(y));
            
           // System.out.println(sofar);
            
            if(!sofar.contains(y)){
                sofar.add(y);
                far++;
                r++;
               // System.out.println("not contain:"+far+" y:"+y+" r:"+r);
            }else{
                ans = Math.max(ans,far);
                far --;
                sofar.remove(x);
                l++;
               // System.out.println("contain:"+far+" y:"+y);
            }   
        }
        if(r>=s.length()) ans = Math.max(ans,far);
        return ans;
    }
}
