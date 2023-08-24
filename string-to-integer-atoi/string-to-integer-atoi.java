class Solution {
    public int myAtoi(String s) {
        String num = "";
        int i=0;
        while(i<s.length()&&s.charAt(i)==' ') i++;
        boolean neg = false;
        if(i<s.length()&&s.charAt(i)=='-') {
            neg=true;
            i++;
        }else if(i<s.length()&&s.charAt(i)=='+'){
            i++;
        }
        while(i<s.length()){
            char c = s.charAt(i);
            if(c>='0'&&c<='9'){
                num+=c;
            }else break;
            i++;
        }
        if(num.equals("")) return 0;
        int res=0;
        try{
            res = Integer.parseInt(num);
            res = neg?-1*res:res;
        }catch(Exception e){
            if(neg){
                return (int)Math.pow(-2,31);
            }else{
                return (int)Math.pow(2,31);
            }
        }
        return res;
    }
}