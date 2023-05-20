class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("")) {
            return "";
        }
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(i==j) dp[i][j] = 1;
                else dp[i][j] = -1;
            }
        }
        int start = 0;
        int end = 0;
        int diff = 1;
        for(int i=s.length()-2;i>-1;i--){
            for(int j=i+1;j<s.length();j++){
                if(dp[i][j]==-1){
                    if(s.charAt(j)==s.charAt(i)&&((j-1>=i+1&&dp[i+1][j-1]==1)||(j-i==1))){
                        dp[i][j] = 1;
                        dp[j][i] = 1;
                        if(j+1-i>diff){
                            start = i;
                            end = j;
                            diff = j+1-i;
                        }
                    }else {
                        dp[i][j] = 0;
                        dp[j][i] = 0;
                    }
                }  
            }
        }
        return s.substring(start,end+1);

    }
}