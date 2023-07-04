class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        st.push(asteroids[0]);
        for(int i=1;i<asteroids.length;i++){
            int curr = asteroids[i];
            if(st.isEmpty()) {
                st.push(curr);
                continue;
            }
            int top = st.peek();
            if(curr<0&&top>0){
                while(!st.isEmpty()&&curr<0&&top>0&&Math.abs(curr)>=top){
                    if(Math.abs(curr)==top) {
                        st.pop();
                        break;
                    }
                    else if(Math.abs(curr)>top){
                        st.pop();
                    }
                    if(!st.isEmpty()){
                        top = st.peek();
                        if((curr<0&&top<0)||(curr>0&&top>0)){
                            st.push(curr);
                        }
                    }
                }
                if(st.isEmpty()){
                    if(Math.abs(curr)>top) st.push(curr);
                }
            }else{
                st.push(curr);
            }
        }
        int[] ans = new int[st.size()];
        int j = st.size()-1;
        while(!st.isEmpty()){
            ans[j] = st.pop();
            j--;
        }
        return ans;
    }
}