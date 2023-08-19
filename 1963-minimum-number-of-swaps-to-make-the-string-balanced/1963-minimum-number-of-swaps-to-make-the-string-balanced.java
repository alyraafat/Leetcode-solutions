class Solution {
    public int minSwaps(String s) {
        int close = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==']') close++;
            else close--;
            max = Math.max(max,close);
        }
        return (max+1)/2;
    }
}