//Given a string s of lower and upper case English letters.

//A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

//0 <= i <= s.length - 2
//s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
//To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

//Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

//Notice that an empty string is also good.


class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(st.empty()) st.push(c);
            else{
                char x = st.peek();
                char c1 = Character.toLowerCase(x);
                char c2 = Character.toLowerCase(c);
                if(c1==c2&&x!=c){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }
        String out="";
        while(!st.empty()){
            out=st.pop()+out;
        }
        return out;
    }
}
