class Solution {
    public int heightChecker(int[] heights) {
        int[] arr = heights.clone();
        int j=1;
        boolean hasSwapped = true;
        while(hasSwapped){
            hasSwapped=false;
            for(int i=0;i<arr.length-j;i++){
                if(arr[i]>arr[i+1]){
                    int temp=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                    hasSwapped=true;
                }
            }
            j++;
        }
        int ans=0;
        for(int z=0;z<heights.length;z++){
            if(heights[z]!=arr[z]) ans++;
        }
        return ans;
    }
}