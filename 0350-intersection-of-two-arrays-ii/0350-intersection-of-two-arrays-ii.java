class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] temp = nums1.length>nums2.length?nums1:nums2;
        int[] other = temp==nums1?nums2:nums1;
        for(int num: temp){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer>arr = new ArrayList<>();
        for(int num: other){
            if(map.containsKey(num)&&map.get(num)>0){
                arr.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        int[] ans = new int[arr.size()];
        int i=0;
        for(int num: arr){
            ans[i++]=num;
        }
        return ans;
    }
}