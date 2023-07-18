class Solution {
    HashMap<String,ArrayList<Pair<int[],Integer>>> map = new HashMap<>();
    public int maximumDetonation(int[][] bombs) {
        for(int i=0;i<bombs.length;i++){
            int[] curr = bombs[i];
            for(int j=0;j<bombs.length;j++){
                int[] b = bombs[j];
                if(j!=i){
                    if(dist(curr,b)){
                        ArrayList<Pair<int[],Integer>> arr = map.getOrDefault(hash(curr,i),new ArrayList<>());
                        arr.add(new Pair<>(b,j));
                        map.put(hash(curr,i),arr);
                    }
                }
            }
        }
        int ans=1;
        for(int i=0;i<bombs.length;i++){
            HashSet<String> seen = new HashSet<>();
            int[] bomb = bombs[i];
            seen.add(hash(bomb,i));
            dfs(bomb,seen,i);
            ans = Math.max(ans,seen.size());
        }
        return ans;
    }
    public boolean dist(int[] a1,int[] a2){
        int xi = a1[0], yi = a1[1], ri = a1[2];
        int xj = a2[0], yj = a2[1];
        return (long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj);
    }
    public String hash(int[] arr,int i){
        return ""+arr[0]+arr[1]+arr[2]+i;
    }
    public void dfs(int[] bomb,HashSet<String> seen,int i){
        String hash = hash(bomb,i);
        if(map.get(hash)==null) return;
        for(Pair<int[],Integer> p: map.get(hash)){
            int[] b = p.getKey();
            int j = p.getValue();
            if(!seen.contains(hash(b,j))){
                seen.add(hash(b,j));
                dfs(b,seen,j);
            }
        }
    }
}