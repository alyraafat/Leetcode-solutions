class State{
    int i;
    int steps;
    public State(int i, int steps){
        this.i = i;
        this.steps = steps;
    }
}
class Solution {
    HashSet<Integer> seen = new HashSet<>();
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        int end = -1;
        for(int i=0;i<wordList.size();i++){
            String currWord = wordList.get(i);
            if(currWord.equals(endWord)) end=i;
            for(int j=i+1;j<wordList.size();j++){
                String target = wordList.get(j);
                if(isDifferentByOne(currWord,target)){
                    ArrayList<Integer> arr1 = map.getOrDefault(i,new ArrayList<>());
                    arr1.add(j);
                    map.put(i,arr1);
                    ArrayList<Integer> arr2 = map.getOrDefault(j,new ArrayList<>());
                    arr2.add(i);
                    map.put(j,arr2);
                }
            }
        }
        Queue<State> q = new LinkedList<>();
        q.add(new State(wordList.size()-1,1));
        // seen.add(wordList.size()-1);
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                State curr = q.poll();
                seen.add(curr.i);
                if(map.get(curr.i)==null) continue;
                for(int t: map.get(curr.i)){
                    if(t==end) return 1+curr.steps;
                    if(!seen.contains(t))
                        q.add(new State(t,1+curr.steps));
                }
            }
        }

        return 0;
    }
    public boolean isDifferentByOne(String s1, String s2){
        int diff = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
               diff++; 
            }
            if(diff>1){
                return false;
            }
        }
        return diff==1;
    }
}