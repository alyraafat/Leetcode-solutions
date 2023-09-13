class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s2 = generateStr(s);
        String t2 = generateStr(t);
        return s2.equals(t2);
    }
    public String generateStr(String x){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<x.length();i++){
            char curr = x.charAt(i);
            if(curr=='#'){
                if(!s.isEmpty()) s.pop();
            }else{
                s.add(curr);
            }
        }
        String a = "";
        while(!s.isEmpty()){
            a = s.pop()+a;
        }
        return a;
    }
}