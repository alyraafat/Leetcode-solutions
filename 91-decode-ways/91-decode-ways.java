class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if(s.charAt(0)=='0') return 0;
        dp[0] = 1;
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            int currInt = Integer.parseInt(""+curr);
            String sofar = ""+prev+curr;
            int sofarInt = Integer.parseInt(sofar);
            boolean isCurrDecodable = currInt>=1&&currInt<=9;
            boolean isSofarDecodable = sofarInt>=10&&sofarInt<=26;
            if(isCurrDecodable&&isSofarDecodable){
                dp[i] = dp[i-1];
                if(i<=1) dp[i]+=1;
                else dp[i]+=dp[i-2];
            }else if(isCurrDecodable&&!isSofarDecodable) {
                dp[i] = dp[i-1];
            }else if(!isCurrDecodable){
                if(isSofarDecodable){
                    if(i<=1) dp[i] = dp[i-1];
                    else dp[i] = dp[i-2];
                }else {
                    return 0;
                }
            }
        }
        return dp[dp.length-1];
        
    }
    
}