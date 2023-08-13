class Solution {
    long[] memo;
    int mod = 1000000007;
    public HashSet<Integer> primes(int n){
        boolean prime[] = new boolean[n+1];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<=n;i++)
            prime[i] = true;
         
        for(int p=2; p*p<=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for(int i=2;i<=n;i++){
            if(prime[i]) set.add(i);
        }
        return set;
    }
    public int numPrimeArrangements(int n) {
        HashSet<Integer> p = primes(n);
        memo=new long[n+1];
        Arrays.fill(memo,-1);
        long fPrime = fac(p.size());
        long fNotPrime = fac(n-p.size());
        long fAll=(fPrime*fNotPrime)%mod;
        int ans = (int)(fAll);
        return ans;
    }
    public long fac(int n){
        if(n==0||n==1) return 1;
        if(memo[n]!=-1) return memo[n];
        memo[n]=(n*fac(n-1))%mod;
        return memo[n];
    }
}