class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<String>();
        HashMap<String,Integer> freq = new HashMap<String,Integer>();
        for(String word : words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>((s1,s2)->{
            if(freq.get(s1)==freq.get(s2)){
                return s2.compareTo(s1);
            }
            return freq.get(s1)-freq.get(s2);
        });
        for(String word : freq.keySet()){
            heap.add(word);
            if(heap.size()>k) heap.remove();
        }
        while(heap.size()>0){
            ans.add(0,heap.remove());
        }
        return ans;
        
        

        
    }
}