class Solution {
    public int countSubstrings(String s) {
        int ans = s.length();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i] = true;
            if(i<s.length()-1){
                dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
                if(dp[i][i+1]){
                    ans+=1;
                }
            }
        }
        for(int i=s.length()-3;i>-1;i--){
            for(int j=i+2;j<s.length();j++){
              if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                  dp[i][j] = true; 
                  ans+=1;
              }  
            }
            
        }
        return ans;
    }
}