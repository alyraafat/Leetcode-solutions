class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int i=0;
        int sum=0;
        int j=0;
        while(j<arr.length){
            if(j-i<k) {
                sum+=arr[j];
            }else{
                if(sum/k>=threshold) ans+=1; 
                sum-=arr[i];
                i++;
                sum+=arr[j];
            }
            j++;
        }
        if(j-i==k&&sum/k>=threshold) ans+=1; 

        return ans;
    }
}