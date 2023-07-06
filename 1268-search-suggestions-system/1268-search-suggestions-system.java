class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        ArrayList<List<String>> ans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        for(String s: products){
            temp.add(s);
        }
        // System.out.println(temp);
        int left=0;
        int right=temp.size()-1;
        for(int i=0;i<searchWord.length();i++){
            char curr = searchWord.charAt(i);
            while(left<=right&&((i>=temp.get(left).length())||(i<temp.get(left).length()&&temp.get(left).charAt(i)<curr)))
                left++;
            while(left<=right&&((i>=temp.get(right).length())||(i<temp.get(right).length()&&temp.get(right).charAt(i)>curr))) 
                right--;
            int c=left;
            ArrayList<String> a = new ArrayList<>();
            while(c<Math.min(left+3,right+1)){
                String s1 = temp.get(c);
            //     // System.out.print(s1+",");
                if(i<s1.length()&&s1.charAt(i)==curr) a.add(s1);
                else break;
                c++;
            }
            // left=0;
            // right=temp.size()-1;
            // System.out.println("left: "+left+",right: "+right); 
            // while(left<=right){
            //     int mid=left+(right-left)/2;
            //     String s = temp.get(mid);
            //     if(i<s.length()&&s.charAt(i)==curr){
            //         right=mid-1;
            //     }else if(i<s.length()&&s.charAt(i)>curr){
            //         right=mid-1;
            //     }else{
            //         left=mid+1;
            //     }
            // }
            // System.out.println("right after:"+right);
            // int c = right+1;
            // ArrayList<String> a = new ArrayList<>();
            // while(c<=right+3&&c<temp.size()){
            //     String s1 = temp.get(c);
            //     // System.out.print(s1+",");
            //     if(i<s1.length()&&s1.charAt(i)==curr) a.add(s1);
            //     else break;
            //     c++;
            // }
            // System.out.println();
            // if(a.size()!=0){
            //     left=right+1;
            //     right=Math.min(left+2,temp.size()-1);
            // }
            // System.out.println(left+", right:"+right+":"+temp);
            ans.add(a);
        }
        return ans;
    }
}