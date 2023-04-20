class Pair {
    String node;
    int steps;
    Pair(String node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}
class Solution {
    HashSet<String> wordSet = new HashSet<String>();
    HashSet<String> seen = new HashSet<String>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String word: wordList){
            wordSet.add(word);
        }
        if(!wordSet.contains(endWord)){
            return 0;
        }
        wordSet.add(beginWord);
        seen.add(beginWord);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.remove();
            String str = p.node;
            int steps = p.steps;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                for (int j=0;j<26;j++) {
                    char curr = (char)('a'+j);
                    if(curr==c){
                        continue;
                    }
                    String newWord = str.substring(0, i) + ("" + curr) + str.substring(i + 1);

                    if(!seen.contains(newWord)&&wordSet.contains(newWord)){
                        seen.add(newWord);
                        if(newWord.equals(endWord)) return steps+1;
                        q.add(new Pair(newWord,steps+1));
                    }
                }
            }
        }
        return 0;
        
    }
}