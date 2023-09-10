class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;
        int max=0;
        int j=0;
        for(;j<s.length();j++){
            char curr = s.charAt(j);
            if(map.containsKey(curr)||(!map.containsKey(curr)&&map.keySet().size()<2)){
                map.put(curr,map.getOrDefault(curr,0)+1);
                max = Math.max(max,j-i+1);
                
            }else{
                while(map.keySet().size()>=2){
                    char left = s.charAt(i);
                    map.put(left,map.get(left)-1);
                    if(map.get(left)==0){
                        map.remove(left);
                    }
                    i++;
                }
                map.put(curr,map.getOrDefault(curr,0)+1);
            }
        }
        
        return max;
    }
}