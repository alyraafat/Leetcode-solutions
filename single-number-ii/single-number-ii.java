class Solution {
    public int singleNumber(int[] nums) {
        long sum1=0;
        long sum2=0;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums) {
            if(!set.contains(num)){
                set.add(num);
                sum1+=num;
            }
            sum2+=num;
        }
        return (int)((sum1*3-sum2)/2);
    }
}