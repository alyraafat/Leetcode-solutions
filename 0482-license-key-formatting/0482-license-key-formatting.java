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
        int i=0;
        while(i<ans.length()&&ans.charAt(i)=='-') {
            ans.replace(i,i+1,"");
            i++;
        }
        return ans.toString();
    }
}