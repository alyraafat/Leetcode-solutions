class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer first = null;
        Integer second = null;
        for(int num: nums){
            if(first==null){
                first = num;
            }else if(num>first){
                if(second==null||num<=second){
                    second=num;
                }else {
                    return true;
                }
            }else if(num<first){
                first = num;
            }
        }
        return false;
    }
}