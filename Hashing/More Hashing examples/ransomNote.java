//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//Each letter in magazine can only be used once in ransomNote.

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
        for(int i=0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            if(m.getOrDefault(c,0)==0) return false;
            else{
                m.put(c,m.getOrDefault(c,0)-1);
            }
        }
        return true;
    }
}
