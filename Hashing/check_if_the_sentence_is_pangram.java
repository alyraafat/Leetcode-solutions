//A pangram is a sentence where every letter of the English alphabet appears at least once.
//Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> seen = new HashSet<Character>();
        for(int i=0;i<sentence.length();i++){
            seen.add(sentence.charAt(i));
        }
        
        if(seen.size()==26)return true;
        return false;
        
    }
}
