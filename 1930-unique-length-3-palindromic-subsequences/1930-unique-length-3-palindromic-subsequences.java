class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<Character> charSeen = new HashSet<>();
        int c = 0;
        int latest = -1;
        for(int i=0;i<s.length();i++){
            if(!charSeen.contains(s.charAt(i))){
                charSeen.add(s.charAt(i));
                int j=s.length()-1;
                for(;j>i;j--){
                    if(s.charAt(i)==s.charAt(j)) break;
                }
                int x = i+1;
                while(x<j){
                    String t = ""+s.charAt(i)+s.charAt(x);
                    if(!seen.contains(t)) seen.add(t);
                    x++;
                }
            }
        }
        return seen.size();
                // HashSet<String> seen = new HashSet<>();

//         for(int i=0;i<s.length();i++){
//             String t = ""+s.charAt(i);
//             for(int j=i+1;j<s.length();j++){
//                 t+=(s.charAt(j));
//                 for(int k=j+1;k<s.length();k++){
//                     if(s.charAt(k)==s.charAt(i)){
//                         seen.add(t);
//                     }  
//                 }
//                 t = ""+s.charAt(i);
//             }
            
//         }
//         return seen.size();
    }
}