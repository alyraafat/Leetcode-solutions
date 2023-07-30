class Solution {
    Boolean[][] memo;
    String s;
    String p;
    public boolean isMatch(String s, String p) {
        memo=new Boolean[s.length()+1][p.length()+1];
        this.s=s;
        this.p=p;
        return dp(0,0);
    }
    public boolean dp(int i, int j){
        if(i>=s.length()&&j>=p.length()) return true;
        if(j==p.length()) return false;
        if(memo[i][j]!=null) return memo[i][j];
        if(i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')){
            if(j<p.length()-1&&p.charAt(j+1)=='*'){
                memo[i][j] =dp(i+1,j)||dp(i+1,j+2)||dp(i,j+2);
            }else{
                memo[i][j]=dp(i+1,j+1);
            }
        }
        else{
            memo[i][j]=false;
            if(j<p.length()-1&&p.charAt(j+1)=='*'){
                memo[i][j]=dp(i,j+2);
            }
        }
        return memo[i][j];
        
    }
}