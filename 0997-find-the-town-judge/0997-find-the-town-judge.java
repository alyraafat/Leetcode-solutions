class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for(int[] t: trust){
            HashSet<Integer> temp=map.getOrDefault(t[0],new HashSet<>());
            temp.add(t[1]);
            map.put(t[0],temp);
        }
        ArrayList<Integer> notSeen = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(map.containsKey(i)) continue;
            notSeen.add(i);
        }            
        // System.out.println(map);

        if(notSeen.size()==1){
            int seen = 0;
            int judge = notSeen.get(0);
            for(int i=1;i<=n;i++){
                if(i==judge) continue;
                if(map.get(i).contains(judge)) seen++;
                else return -1;
            }
            if(seen==n-1) return judge;
        }
        return -1;
    }
}