class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        ArrayList<List<String>> ans = new ArrayList<>();
        int left=0;
        int right=products.length-1;
        for(int i=0;i<searchWord.length();i++){
            char curr = searchWord.charAt(i);
            while(left<=right&&((i>=products[left].length())||(i<products[left].length()&&products[left].charAt(i)<curr)))
                left++;
            while(left<=right&&((i>=products[right].length())||(i<products[right].length()&&products[right].charAt(i)>curr))) 
                right--;
            int c=left;
            ArrayList<String> a = new ArrayList<>();
            while(c<Math.min(left+3,right+1)){
                String s1 = products[c];
                if(i<s1.length()&&s1.charAt(i)==curr) a.add(s1);
                else break;
                c++;
            }
            ans.add(a);
        }
        return ans;
    }
}