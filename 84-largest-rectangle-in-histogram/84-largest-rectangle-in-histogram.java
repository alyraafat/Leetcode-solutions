class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        int max = heights[heights.length-1];
        st.push(new Pair<>(heights[heights.length-1],1));
        for(int i=heights.length-2;i>-1;i--){
            int height = heights[i];
            int curr=1;
            int diff=0;
            while(!st.isEmpty()&&height<st.peek().getKey()){
                max = Math.max(max,st.peek().getKey()*st.peek().getValue());
                curr=(int)st.peek().getValue()+1;
                st.pop();
            }
            max=Math.max(max,height*curr);
            Stack<Pair<Integer,Integer>> temp = new Stack<>();
            while(!st.isEmpty()){
                // System.out.print("st before: "+st);
                Pair top = st.pop();
                // System.out.print(" , i="+i+","+top+",");
                Pair top2 = new Pair<>(top.getKey(),1+(int)top.getValue());                         temp.push(top2);
                // System.out.println(" , st after: "+st);
            }
            while(!temp.isEmpty()){
                st.push(temp.pop());
            }
            if(!(!st.isEmpty()&&st.peek().getKey()==height))
                st.push(new Pair<>(height,curr));
            // System.out.println(" , st after: "+st);            
        }
        while(!st.isEmpty()){
            max = Math.max(max,st.peek().getKey()*st.peek().getValue());
            st.pop();
        }
        return max;
    }
}