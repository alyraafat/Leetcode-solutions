
class FreqStack {
    Stack<int[]> st;
    HashMap<Integer,Integer> map;
    PriorityQueue<Integer> pq;
    public FreqStack() {
        st = new Stack<>();
        map = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void push(int val) { 
        // Stack<int[]> temp = new Stack<>();
        // while(!st.isEmpty()&&st.peek()[0]!=val){
        //     temp.push(st.pop());
        // }
        // int[] ins;
        // if(st.isEmpty()) {
        //     ins = new int[]{val,1};
        // }
        // else{
        //     ins = new int[]{val,st.peek()[1]+1};
        // }
        // while(!temp.isEmpty()){
        //     st.push(temp.pop());
        // }
        // st.push(ins);
        // pq.add(ins[1]);
        map.put(val,map.getOrDefault(val,0)+1);
        st.push(new int[]{val,map.get(val)});
        pq.add(map.get(val));
    }
    
    public int pop() {
        // System.out.print("st: [");
        // for(int[] a: st){
        //     System.out.print("["+a[0]+","+a[1]+"],");
        // }
        // System.out.println("pq: "+pq);
        int freq = pq.remove();
        Stack<int[]> temp = new Stack<>();
        while(!st.isEmpty()&&st.peek()[1]!=freq){
            temp.push(st.pop());
        }
        int[] del = st.pop();
        map.put(del[0],map.getOrDefault(del[0],0)-1);
        if(map.get(del[0])<=0) map.remove(del[0]);
        while(!temp.isEmpty()){
            st.add(temp.pop());
        }
        return del[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */