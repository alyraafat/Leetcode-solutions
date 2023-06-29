class Solution {
    public long distinctNames(String[] ideas) {
        long ans = 0;
        HashMap<Character,HashSet<String>> map = new HashMap<>();
       
        for(String s: ideas){
            StringBuilder sb = new StringBuilder(s);
            String x = sb.substring(1).toString();
            char c = sb.charAt(0);
            HashSet<String> temp = map.getOrDefault(c,new HashSet<String>());
            temp.add(x);
            map.put(c,temp);
        }
        for(char key: map.keySet()){
            HashSet<String> sufSet = map.get(key);
            for(char key2: map.keySet()){
                int mutual = 0;
                if(key!=key2){
                    for(String s: sufSet){
                        if(map.get(key2).contains(s)) mutual++;
                    } 
                    ans+=(sufSet.size()-mutual)*(map.get(key2).size()-mutual);
                }
            }
        }
       
        return ans;
    }
}