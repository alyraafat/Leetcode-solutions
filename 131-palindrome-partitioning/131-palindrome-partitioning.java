class Solution {
    ArrayList<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(new StringBuilder(s),0,new ArrayList<>());
        return ans;
    }
    public void backtrack(StringBuilder s, int i, ArrayList<String> temp){
        if(i==s.length()){
            ArrayList<String> copy = new ArrayList<>(temp);
            // if(!ans.contains(copy)) 
                ans.add(copy);
            return;
        }
        // ArrayList<String> copy = new ArrayList<>(temp);
        
        for(int j=i;j<s.length();j++){
            String curr = s.substring(i,j+1);
            if(!isPalindrome(s.toString(),i,j)){
                continue;
            }else{
                temp.add(curr);
                backtrack(s,j+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}