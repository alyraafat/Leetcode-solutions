class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        StringBuilder s = new StringBuilder();
        while(i<word1.length()||j<word2.length()){
            if(i<word1.length()&&j<word2.length()){
                s.append(""+word1.charAt(i)+word2.charAt(j));
                i++;
                j++;
            }else if(i<word1.length()){
                s.append(""+word1.charAt(i));
                i++;
            }else{
                s.append(""+word2.charAt(j));
                j++;
            }
        }
        return s.toString();
    }
}