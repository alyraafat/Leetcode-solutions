class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        int[] temp = nums1.length>nums2.length?nums1:nums2;
        int[] other = temp==nums1?nums2:nums1;
        Arrays.sort(other);
        for(int num: temp){
            if(!seen.contains(num)){
                seen.add(num);
                if(found(num,other)){
                    arr.add(num);
                }
            }
        }
        int[] ans = new int[arr.size()];
        int i=0;
        for(int num: arr){
            ans[i]=num;
            i++;
        }
        return ans;
    }
    public boolean found(int num,int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==num){
                return true;
            }else if(nums[mid]<num){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
}