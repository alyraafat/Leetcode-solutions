class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if(x==1) return 1;
        
        double ans = 1;
        boolean neg = n<0;
        long k = neg?-1*(long)n:n;
        boolean odd = k%2==1;
        if(x==-1){
            if(k%2==0){
                ans=1;
            }else{
                ans=-1;
            }
            return ans;
        }
        k/=2;
        while(k>0){
            ans *= x*x;
            k--;
        }
        if(odd) ans*=x;
        return neg?1/ans:ans;
    }
}