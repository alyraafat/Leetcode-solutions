class Solution {
    public String convertToBase7(int num) {
        String ans="";
        int z=num;
        if(num<0) num*=-1;
        if(num==0) ans="0";
        while(num>0){
            int rem = num%7;
            num/=7;
            ans=rem+ans;
        }
        return z<0?"-"+ans:ans;
    }
}