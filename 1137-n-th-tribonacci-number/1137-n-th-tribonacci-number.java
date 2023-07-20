class Solution {
    public int tribonacci(int n) {
        int zero = 0;
        int first = 1;
        int second = 1;
        if(n==0) return zero;
        if(n==1) return first;
        if(n==2) return second;
        int ans=0;
        for(int i=3;i<=n;i++){
            ans=zero+first+second;
            zero=first;
            first=second;
            second=ans;
        }
        return ans;
    }
}