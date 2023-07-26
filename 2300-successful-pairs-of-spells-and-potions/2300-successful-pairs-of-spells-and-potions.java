class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            ans[i] = binarySearch(success,spells[i],potions);
        }
        return ans;
    }
    public int binarySearch(long success, int spell,int[] potions){
        int i=0;
        int j=potions.length-1;
        while(i<=j){
            int mid = (j-i)/2 + i;
            long prod = (long)spell*(long)potions[mid];
            if(prod<success){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return potions.length-i;
    }
}