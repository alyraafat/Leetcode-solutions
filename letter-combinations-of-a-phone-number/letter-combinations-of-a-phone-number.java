class Solution {
    public List<String> letterCombinations(String digits) {
        String[][] telephone = new String[][]{{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        List<String> ans = new ArrayList<>();
        if(digits.equals("")) return ans;
        String curr = "";
        backtrack(curr, ans, 0,digits, telephone);
        return ans;
    }
    
    public void backtrack(String curr, List<String> ans, int i, String digits, String[][] telephone) {
        if (i==digits.length()) {
            String s = new String(curr);
            ans.add(s);
            return;
        }
        int j = Integer.parseInt(""+digits.charAt(i))-2;
        for (String letter: telephone[j]) {
            curr+=letter;
            backtrack(curr, ans,i+1,digits, telephone);
            curr=curr.substring(0,curr.length()-1);     
        } 
    }
}