class Solution {
    public int maximum69Number (int num) {
        String s = ""+num;
        String ansStr = "";
        for(int i=0;i<s.length();i++){
            ansStr = "";
            if(s.charAt(i)=='6'){
                ansStr = s.substring(0,i)+'9'+s.substring(i+1);
                int ans = Integer.parseInt(ansStr);
                if(ans>num) {
                    return ans;
                }
            }
        }
        return num;
    }
}