class Solution {
    HashSet<String> set = new HashSet<>();
    Boolean[][] memo;
    String s;
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict) set.add(word);
        this.s=s;
        memo = new Boolean[s.length()][s.length()];
        return topdown(0,0);
    }
    public boolean topdown(int st, int e){
        if(e==s.length()) return set.contains(s.substring(st,e));
        if(memo[st][e]!=null) return memo[st][e];
        String curr = s.substring(st,e);
        if(set.contains(curr)){
            memo[st][e] = topdown(st,e+1) || topdown(e,e);
        }else{
            memo[st][e] = topdown(st,e+1);
        }
        return memo[st][e];
    }
}