public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i=31;
        int ans=0;
        while(n!=0){
            boolean isOne = (n&1)==1;
            n=n>>>1;
            if(isOne) ans |= 1 << i;
            i--;
        }
        return ans;
    }
}