class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        HashMap<Character,Integer> temp = new HashMap<>();
        int i=0;
        for(int j=0;j<s2.length();){
            char curr = s2.charAt(j);
            if(j-i<s1.length()&&map.containsKey(curr)){
                temp.put(curr,temp.getOrDefault(curr,0)+1);
                j++;
                if(j==s2.length()&&j-i==s1.length()) {
                    return areMapsEqual(map,temp);
                }
            }else if(j-i>=s1.length()){
                if(areMapsEqual(map,temp)) return true;
                char prev = s2.charAt(i);
                temp.put(prev,temp.get(prev)-1);
                if(temp.get(prev)<=0) temp.remove(prev);
                i++;
            }else if(!map.containsKey(curr)){
                j++;
                i=j;
                temp.clear();
            }
        }
        return false;
    }
    private boolean areMapsEqual(HashMap<Character,Integer> m1,HashMap<Character,Integer> m2){
        for(char key: m1.keySet()){
            if(!m1.get(key).equals(m2.get(key))) return false;
        }
        return true;
    }
}