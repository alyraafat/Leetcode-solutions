class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int i=0;
        int sum=0;
        int c=0;
        int j=0;
        for(;j<arr.length;j++){
            if(j-i<k) {
                sum+=arr[j];
            }else{
                // System.out.println(sum);
                if(sum/k>=threshold) ans+=1; 
                sum-=arr[i];
                i++;
                sum+=arr[j];
            }
        }
        if(j-i==k&&sum/k>=threshold) ans+=1; 

        return ans;
    }
}