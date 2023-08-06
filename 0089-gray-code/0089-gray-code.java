class Solution {
    int n;
    public List<Integer> grayCode(int n) {
        int max = (int)(Math.pow(2,n)-1);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        this.n=n;
        backtrack(arr,max, new HashSet<>());
        return arr;
    }
    public boolean backtrack(ArrayList<Integer> arr, int max,HashSet<Integer> seen){
        if(arr.size()==max+1) {
            return hammingWeight(0^arr.get(arr.size()-1));
        }
        
        for(int j=0;j<n;j++){
            int prev = arr.get(arr.size()-1);
            int curr = prev^(1<<j);
            if(seen.contains(curr)) continue;
            seen.add(curr);
            arr.add(curr);
            if(backtrack(arr,max,seen)) return true;
            arr.remove(arr.size()-1);
            seen.remove(curr);
        }
        
        return false;
    }
    public boolean hammingWeight(int n) {
        int ones=0;
        while(n!=0){
            boolean isOne = (n&1)==1;
            n=n>>>1;
            if(isOne) ones++;
            if(ones>1) return false;
        }
        return true;
    }
}