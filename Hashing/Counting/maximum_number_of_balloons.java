//Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
//You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
        int n = 0;
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            if(c=='b'||c=='a'||c=='l'||c=='o'||c=='n'){
                m.put(c,m.getOrDefault(c,0)+1);
            }             
            if(m.containsKey('b')&&m.get('b')>=1&&m.containsKey('a')&&m.get('a')>=1&&m.containsKey('l')&&m.get('l')>=2&&m.containsKey('o')&&m.get('o')>=2&&m.containsKey('n')&&m.get('n')>=1){
              n++;
              m.put('b',m.get('b')-1);
              m.put('a',m.get('a')-1);
              m.put('l',m.get('l')-2);
              m.put('o',m.get('o')-2);
              m.put('n',m.get('')-1);
            }
        }
         
     return n;  
    }
}
