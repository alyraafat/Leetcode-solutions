class Solution {
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new Boolean[s1.length()+1][s2.length()+1];
        if(s3.length()!=(s1.length()+s2.length())) return false;
        // for(int i=0;i<memo.length;i++){
        //     Arrays.fill(memo[i],-1);
        // }
        return dp(0,0,0,s1,s2,s3);
    }
    public boolean dp(int i, int j, int k, String s1, String s2, String s3){
        if(k==s3.length()) return true;
        if(j>=s2.length()&&i>=s1.length()) return false;
        char c3 = s3.charAt(k);
        if(j>=s2.length()){
            char c1 = s1.charAt(i);
            if(c3==c1){
                memo[i][j] = dp(i+1,j,k+1,s1,s2,s3);
            }else{
                memo[i][j]=false;
            }
            return memo[i][j];
        }
        if(i>=s1.length()){
            char c2 = s2.charAt(j);
            if(c3==c2){
                memo[i][j] = dp(i,j+1,k+1,s1,s2,s3);
            }else{
                memo[i][j]=false;
            }
            return memo[i][j];
        }
        if(memo[i][j]!=null) return memo[i][j];
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        Boolean ans = null;
        if(c3==c2&&c3==c1){
            boolean one = dp(i+1,j,k+1,s1,s2,s3);
            boolean two = dp(i,j+1,k+1,s1,s2,s3);
            ans=one||two;
        }else if(c3==c1){
            ans=dp(i+1,j,k+1,s1,s2,s3);
        }else if(c3==c2){
            ans=dp(i,j+1,k+1,s1,s2,s3);
        }else{
            ans=false;
        }
        memo[i][j]=ans;
        return ans;
    }
}