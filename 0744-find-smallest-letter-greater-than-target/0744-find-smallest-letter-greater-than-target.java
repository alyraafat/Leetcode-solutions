class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right=letters.length-1;
        if(letters[right]<=target) return letters[0];
        while(left<right){
            int mid = left+(right-left)/2;
            if(letters[mid]>target){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return letters[right];
    }
}