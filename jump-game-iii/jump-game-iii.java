class Pair{
    int index;
    int val;
    Pair(int i, int v){
        this.index = i;
        this.val = v;
    }
}
class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        q.add(new Pair(start,arr[start]));
        seen.add(start);
        while(!q.isEmpty()){
            Pair p = q.remove();
            int index = p.index;
            int val = p.val;
            if(arr[index]==0) return true;
            int nextIndex = index+val;
            int prevIndex = index-val;
            if(valid(nextIndex,arr.length)&&!seen.contains(nextIndex)){
                seen.add(nextIndex);
                q.add(new Pair(nextIndex,arr[nextIndex]));
            }
            if(valid(prevIndex,arr.length)&&!seen.contains(prevIndex)){
                seen.add(prevIndex);
                q.add(new Pair(prevIndex,arr[prevIndex]));
            }
        }
        return false;
    }
     public boolean valid(int index,int size){
        if(index<size && index>=0){
            return true;
        }
        return false;
    }
}