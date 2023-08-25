class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>();
        for(String s: banned) bannedSet.add(s);
        HashMap<String,Integer> map = new HashMap<>();
        int j=0;
        StringBuilder temp = new StringBuilder();
        int max=0;
        while(j<paragraph.length()){
            char curr = paragraph.charAt(j);
            if((curr>='a'&&curr<='z')||(curr>='A'&&curr<='Z')){
                String x = (curr+"").toLowerCase();
                temp.append(x);
            }
            else{
                if(temp.length()>0&&!bannedSet.contains(temp.toString())){
                    map.put(temp.toString(),map.getOrDefault(temp.toString(),0)+1);
                    max = Math.max(max,map.get(temp.toString()));
                }
                temp = new StringBuilder();
            }
            j++;
        }
        if(temp.length()>0&&!bannedSet.contains(temp.toString())){
            map.put(temp.toString(),map.getOrDefault(temp.toString(),0)+1);
            max = Math.max(max,map.get(temp.toString()));
        }
        for(String key: map.keySet()){
            if(map.get(key)==max) return key;
        }
        return "";
    }
}