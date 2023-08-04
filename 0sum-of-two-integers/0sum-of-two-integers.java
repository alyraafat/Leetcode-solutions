class Solution {
    public int getSum(int a, int b) {
        int carry=0;
        int ans=0;
        for(int i=0;i<32;i++){
            int ar = a&1;
            int br = b&1;
            a=a>>>1;
            b=b>>>1;
            int sum = ar+br+carry;
            carry=0;
            if(sum==2){
                carry=1;
            }else if(sum==3){
                carry=1;
                ans |= 1<<i;
            }else if(sum==1){
                ans |= 1<<i;
            }
        }
        return ans;
    }
}