class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int i=0;
        int j=0;
        int k=0;
        int[] temp = new int[n+m];
        while(i<m||j<n){
            if(i<m&&j<n){
                if(nums1[i]>=nums2[j]){
                    temp[k] = nums2[j];
                    j++;
                }else{
                    temp[k] = nums1[i];
                    i++;
                }
            }else if(i<m){
                temp[k] = nums1[i];
                i++;
            }else{
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }
        for(int z=0;z<m+n;z++){
            nums1[z] = temp[z];
        }
    }
}