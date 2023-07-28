class Solution {
    int[][] memo;
    // HashMap<String,Integer> memo = new HashMap<>();
    public int minDistance(String word1, String word2) {
        memo=new int[word1.length()+word2.length()][word2.length()];
        for(int[] arr: memo) Arrays.fill(arr,-1);
        return dp(0,0,new StringBuilder(word1),new StringBuilder(word2));
    }
    public int dp(int i, int j,StringBuilder word1, StringBuilder word2){
        if(j==word2.length()&&i==word1.length()) return 0;
        if(j==word2.length()) return word1.length()-i;
        if(i==word1.length()) return word2.length()-j;
        if(memo[i][j]!=-1) return memo[i][j];
        int ways = Integer.MAX_VALUE;
        if(word1.charAt(i)!=word2.charAt(j)){
            int insert = 1+dp(i,j+1,word1,word2);
            int delete = 1+dp(i+1,j,word1,word2);
            int replace = 1+dp(i+1,j+1,word1,word2);
            ways=Math.min(ways,Math.min(insert,Math.min(delete,replace)));
        }
        else{
            ways=Math.min(ways,dp(i+1,j+1,word1,word2));
        }
        memo[i][j]=ways;
        return ways;
    }
    
}