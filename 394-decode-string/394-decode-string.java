class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder ans=new StringBuilder();
        int bracket = 0;
        StringBuilder currStr=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            st.add(curr+"");
        }
        StringBuilder str = new StringBuilder();
        int end = -1;
        while(!st.isEmpty()){
            String curr = st.pop();
            if(curr.equals("]")){
                bracket++;
                str.insert(0,curr);
            }else if(curr.equals("[")){
                bracket--;
                StringBuilder num = new StringBuilder();
                char n = st.peek().charAt(0);
                while(!st.isEmpty()&&n>='0'&&n<='9'){
                    num.insert(0,n);
                    st.pop();
                    if(!st.isEmpty())
                        n = st.peek().charAt(0);
                }
                int x=0;
                int z = Integer.parseInt(num.toString());
                StringBuilder decode = new StringBuilder();
                char c1 = str.charAt(x);
                while(c1!=']'){
                    decode.append(c1+"");
                    x++;
                    c1 = str.charAt(x);
                }
                // System.out.println(str.toString()+","+x);
                int r = 1;
                StringBuilder d = new StringBuilder();
                while(r<=z){
                    d.append(decode.toString());
                    r++;
                }
                str.replace(0,x+1,d.toString());
                if(bracket==0){
                    ans.insert(0,new StringBuilder(str).toString());
                    str = new StringBuilder();
                }
            }else if(bracket==0){
                ans.insert(0,curr+new StringBuilder(str).toString());
                str = new StringBuilder();
            }else if(bracket>0){
                str.insert(0,curr);
            }
        }
        return ans.toString();
    }
}