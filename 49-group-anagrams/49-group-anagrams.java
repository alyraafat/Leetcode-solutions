class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> ans = new ArrayList<>();
        if(strs.length==1) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(strs[0]);
            ans.add(temp);
            return ans;
        }
        HashMap<String,ArrayList<String>> map = new HashMap<>(); 
        for(String str: strs){
            char charArray[] = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            ArrayList<String> val = map.getOrDefault(key,new ArrayList<String>());
            val.add(str);
            map.put(key,val);
        }
        for(String key: map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}