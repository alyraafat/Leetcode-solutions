class Solution {
    public String toHex(int num) {
        if(num==-1*Math.pow(2,31)) return "80000000";
        int z=num<0?num*-1:num;
        if(num==0) return "0";
        StringBuilder ans=new StringBuilder();
        while(z>0){
            int rem=z%2;
            z/=2;
            ans.insert(0,rem+"");
        }
        if(num<0){
            int size=ans.length();
            for(int i=1;i<=32-size;i++) {
                // System.out.println(i);
                ans.insert(0,"0");
            }
            // System.out.println("before flip: "+ans);
            for(int i=0;i<ans.length();i++){
                String rep = ans.charAt(i)=='0'?"1":"0";
                ans.replace(i,i+1,rep);
            }
            // System.out.println("after flip: "+ans);
            if(ans.charAt(ans.length()-1)=='0'){
                ans.replace(ans.length()-1,ans.length(),"1");
            }else{ 
                // System.out.println("after add: "+ans);
                int carry = 0;
                ans.replace(ans.length()-1,ans.length(),"0");
                carry=1;
                for(int i=ans.length()-2;i>=0;i--){
                    if(carry==1){
                        if(ans.charAt(i)=='0'){
                            ans.replace(i,i+1,"1");
                            break;
                        }else{
                            ans.replace(i,i+1,"0");
                        }
                    }
                }
            }
            
        }
        String ans2 = "";
        for(int i=ans.length()-1;i>=0;i-=4){
            String curr = ans.substring(Math.max(0,i-3),i+1);
            ans2 = binToHex(curr)+ans2;
        }
        return ans2;
    }
    public String binToHex(String bin){
        int dec=0;
        for(int i=bin.length()-1;i>=0;i--){
            char c = bin.charAt(i);
            if(c=='1'){
               dec+=(int)Math.pow(2,bin.length()-1-i);
            }
        }
        switch(dec){
            case 10: return "a";
            case 11: return "b";
            case 12: return "c";
            case 13: return "d";
            case 14: return "e";
            case 15: return "f";
            default: return dec+"";
        }
    }
}