class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int c=0;
        for(int i=s.length()-1;i>=0;i--){
            if(c<k){
                if(s.charAt(i)=='-') continue;
                ans.insert(0,(s.charAt(i)+"").toUpperCase());
                c++;
            }else{
                c=0;
                ans.insert(0,"-");
                i++;
            }
        }
        if(ans.length()>0&&ans.charAt(0)=='-'){
            ans.replace(0,1,"");
        }
        return ans.toString();
    }
}