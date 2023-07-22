class Solution {
    HashMap<Integer,Integer> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(dp(0,wordDict,new StringBuilder(s))) return true;
        return false;
    }
    public boolean dp(int i, List<String> wordSet,StringBuilder sb){
        if(i==sb.length()) return true;
        if(memo.containsKey(i)){
            return dp(memo.get(i),wordSet,sb);
        }
        for(String word: wordSet){
            if(i+word.length()<=sb.length()){
                String s = sb.substring(i,word.length()+i);
                if(s.equals(word)){
                    memo.put(i,word.length()+i);
                    if(dp(word.length()+i,wordSet,sb)) return true;
                }
            }
        }
        return false;
    }
}