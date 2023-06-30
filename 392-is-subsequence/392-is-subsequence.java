class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        if(s.length()>t.length()) return false;
        if(s.equals(t)) return true;
        int j = 0;
        boolean isSub = false;
        for(int i=0;i<s.length();i++){
            for(;j<t.length();j++){
                if(s.charAt(i)==t.charAt(j)){
                    if(i==s.length()-1) isSub = true;
                    j++;
                    break;
                }
            }
            
        }
        return isSub;
    }
}