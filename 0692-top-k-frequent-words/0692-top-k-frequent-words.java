class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((s1,s2)->{
            int c = map.get(s1)-map.get(s2);
            if(c==0) return s2.compareTo(s1);
            return c;
        });
        for(String word: map.keySet()){
            pq.add(word);
            if(pq.size()>k) pq.remove();
        }
        ArrayList<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(0,pq.remove());
        }
        return ans;
    }
}