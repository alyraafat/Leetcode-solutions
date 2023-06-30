class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        int j=0;
        int count = 0;
        for(int i=0;i<pattern.length();i++){
            char curr = pattern.charAt(i);
            String str = "";
            if(j==s.length()) return false;
            if(j<s.length()&&s.charAt(j)==' ') {
                j++;
                count++;
            }
            while(j<s.length()&&s.charAt(j)!=' '){
                str+=s.charAt(j);
                j++;
            }
            if(!map.containsKey(curr)){
                if(map.containsValue(str)) return false;
                map.put(curr,str);
            }else{
                if(!map.get(curr).equals(str)) return false;
            }
        }
        if(j<s.length()) return false;
        return true;
    }
}