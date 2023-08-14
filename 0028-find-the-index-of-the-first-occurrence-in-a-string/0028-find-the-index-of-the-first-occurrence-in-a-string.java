class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int j=0;
        int start = -1;
        if(haystack.length()<needle.length()) return start;
        while(i<haystack.length()){
            if(j==needle.length()) return start;
            char c1 = haystack.charAt(i);
            char c2 = needle.charAt(j);
            if(c1==c2){
                if(start==-1) start=i;
                j++;
            }else{
                j=0;
                if(start!=-1){
                    i=start;
                    start=-1;    
                }
                
            }
            i++;
        }
        return j!=needle.length()?-1:start;
    }
}