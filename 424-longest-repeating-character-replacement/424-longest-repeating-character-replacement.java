class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int[] alphabet = new int[26];
        int ans = 0;
        int maxCurr=0;
        int j=0;
        while(j<s.length()){
            alphabet[s.charAt(j)-'A']++;
            int curr = alphabet[s.charAt(j)-'A'];
            maxCurr = Math.max(curr,maxCurr);
            if((j+1-i)-maxCurr<=k){
                j++;
            }else{
                alphabet[s.charAt(i)-'A']--;
                ans = Math.max(ans,j-i);
                i++;
                j++;
            }
        }
        ans = Math.max(ans,j-i);
        return ans;
    }
}