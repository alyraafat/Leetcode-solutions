class Solution {
    ArrayList<List<String>> ans = new ArrayList<>();
    // HashMap<String,Boolean> map = new HashMap<>();
    public List<List<String>> partition(String s) {
        backtrack(new StringBuilder(s),0,new ArrayList<>());
        return ans;
    }
    public void backtrack(StringBuilder s, int i, ArrayList<String> temp){
        if(i==s.length()){
            ArrayList<String> copy = new ArrayList<>(temp);
            ans.add(copy);
            return;
        }
        
        for(int j=i;j<s.length();j++){
            String curr = s.substring(i,j+1);
            if(!isPalindrome(curr)){
                // if(!map.containsKey(curr))map.put(curr,false);
                continue;
            }else{
                temp.add(curr);
                // if(!map.containsKey(curr))map.put(curr,true);
                backtrack(s,j+1,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    boolean isPalindrome(String s) {
        int low=0;
        int high=s.length()-1;
        // if(map.containsKey(s)) return map.get(s);
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}