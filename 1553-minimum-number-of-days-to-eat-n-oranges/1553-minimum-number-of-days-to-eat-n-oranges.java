class Solution {
    public int minDays(int n) {
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(n,0));
        HashSet<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair<Integer,Integer> curr = q.remove();
                int x = curr.getKey();
                int steps = curr.getValue();
                int a = x-1;
                int b = x-(x/2);
                int c = x-2*(x/3);
                int pushed = Math.min(a,Math.min(b,c));
                if(x>0&&!set.contains(a)) {
                    if(a==0) return steps+1;
                    set.add(a);
                    q.add(new Pair<>(x-1,steps+1));
                }
                if(x%2==0&&!set.contains(b)){
                    if(b==0) return steps+1;
                    set.add(b);
                    q.add(new Pair<>(b,steps+1));
                } 
                if(x%3==0&&!set.contains(c)){
                    if(c==0) return steps+1;
                    set.add(c);
                    q.add(new Pair<>(c,steps+1));
                }
            }
        }
        return -1;
    }
}