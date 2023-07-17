class State {
    int node;
    int color;// 1=red, 0=blue
    int steps;
    State(int node, int color, int steps) {
        this.node = node;
        this.color = color;
        this.steps = steps;
    }
    public String toString(){
        return node+","+color+","+steps;
    }
}
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Queue<State> q = new LinkedList<>();
        q.add(new State(0,1,0));
        q.add(new State(0,0,0));
        boolean[][] seen = new boolean[n][2];
        seen[0][0]=true;
        seen[0][1]=true;
        int[] ans = new int[n];
        ans[0] = 0;
        for(int i=1;i<n;i++){
            ans[i] = -1;
        }
        HashMap<Integer,ArrayList<Integer>> redMap = new HashMap<>();
        HashMap<Integer,ArrayList<Integer>> blueMap = new HashMap<>();
        for(int i=0;i<n;i++){
            redMap.put(i,new ArrayList<>());
            blueMap.put(i,new ArrayList<>());
        }
        for(int[] red: redEdges){
            ArrayList<Integer> arr = redMap.get(red[0]);
            arr.add(red[1]);
            redMap.put(red[0],arr);
        }
        for(int[] blue: blueEdges){
            ArrayList<Integer> arr = blueMap.get(blue[0]);
            arr.add(blue[1]);
            blueMap.put(blue[0],arr);
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                State curr = q.remove();
                int color = curr.color;
                if(color==1){
                    for(int node: blueMap.get(curr.node)){
                        if(!seen[node][0]){
                            q.add(new State(node,0,curr.steps+1));
                            ans[node] = ans[node]!=-1?Math.min(ans[node],curr.steps+1):curr.steps+1;
                            seen[node][0]=true;
                        }
                    }
                }else{
                    for(int node: redMap.get(curr.node)){
                        if(!seen[node][1]){
                            q.add(new State(node,1,curr.steps+1));
                            ans[node] = ans[node]!=-1?Math.min(ans[node],curr.steps+1):curr.steps+1;
                            seen[node][1]=true;
                        }
                    }
                }
            }
        }
        return ans;
    }
}