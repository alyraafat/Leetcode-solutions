class Solution {
    public int maximum69Number (int num) {
        String s = ""+num;
        String ansStr = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='6'){
                ansStr += '9'+s.substring(i+1);
                int ans = Integer.parseInt(ansStr);
                if(ans>num) {
                    return ans;
                }
                break;
            }
            ansStr+=s.charAt(i);
        }
        return num;
    }
}