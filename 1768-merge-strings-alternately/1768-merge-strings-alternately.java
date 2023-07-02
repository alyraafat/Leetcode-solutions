class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        String s = "";
        while(i<word1.length()||j<word2.length()){
            if(i<word1.length()&&j<word2.length()){
                s+=""+word1.charAt(i)+word2.charAt(j);
                i++;
                j++;
            }else if(i<word1.length()){
                s+=""+word1.charAt(i);
                i++;
            }else{
                s+=""+word2.charAt(j);
                j++;
            }
        }
        return s;
    }
}