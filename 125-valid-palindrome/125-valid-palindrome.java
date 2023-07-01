class Solution {
    public boolean isPalindrome(String s) {
        String str1 = s.replaceAll("[^a-zA-Z0-9]", "");
        String str2 = str1.toLowerCase();
        int i=0;
        int j=str2.length()-1;
        while(i<j){
            if(str2.charAt(i)!=str2.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}