class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        while(ans.size()<k){
            int prev = x-i;
            int next = x+i;
            if(prev>=arr[0]&&prev<=arr[arr.length-1]){
                int[] prevSearch = binarySearch(prev,arr);                
                if(prevSearch[0]!=-1) {
                    for(int v=1;v<=prevSearch[1]&&ans.size()<k;v++) ans.add(0,prev);
                }
            }
            if(i!=0){
                if(next>=arr[0]&&next<=arr[arr.length-1]){
                    int[] nextSearch = binarySearch(next,arr);
                    if(nextSearch[0]!=-1&&ans.size()<k) {
                        for(int v=1;v<=nextSearch[1]&&ans.size()<k;v++) ans.add(next);
                    }
                }
            }
            i++;
        }
        return ans;
    }
    public int[] binarySearch(int x,int[] arr){
        int i = 0;
        int j= arr.length-1;
        int[] ans = new int[2];
        while(i<=j){
            int mid = i+(j-i)/2;
            if(arr[mid]<x){
                i=mid+1;
            }else if(arr[mid]>x){
                j=mid-1;
            }else{
                ans[0]=mid;
                ans[1]=findOcc(arr,mid);
                return ans;
            }
        }
        ans[0]=-1;
        return ans;
    }
    public int findOcc(int[] nums,int i){
        int count=1;
        for(int x=i-1;x>=0;x--){
            if(nums[i]==nums[x]) count++;
            else break;
        }
        for(int x=i+1;x<nums.length;x++){
            if(nums[i]==nums[x]) count++;
            else break;
        }
        return count;
    }
    
}