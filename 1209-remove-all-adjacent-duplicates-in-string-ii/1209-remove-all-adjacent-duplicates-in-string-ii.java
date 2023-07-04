class Pair{
    char c;
    int count;
    public Pair(char c, int count){
        this.c=c;
        this.count=count;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        char prev = '-';
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        int count=1;
        st.push(new Pair(s.charAt(0),1));
        for(int i=1;i<sb.length();){
            char curr = sb.charAt(i);
            if(count==k){
                while(!st.isEmpty()&&count>0){
                    st.pop();
                    count--;
                }
            }
            if(!st.isEmpty()&&st.peek().c==curr){
                count=1+st.peek().count;
                i++;
            }else{
                count=1;
                i++;
            }
            st.push(new Pair(curr,count));
        }
        if(count==k){
            while(!st.isEmpty()&&count>0){
                st.pop();
                count--;
            }
        }
        while(!st.isEmpty()){
            ans.insert(0,st.pop().c+"");
        }
        return ans.toString();
    }
}