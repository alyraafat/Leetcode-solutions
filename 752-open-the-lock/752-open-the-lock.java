class Solution {
    public int openLock(String[] deadends, String target) {
        // HashSet<String> dead = new HashSet<>();
        HashSet<String> seen = new HashSet<>();
        for(String s: deadends){
            if(s.equals("0000")) return -1;
            seen.add(s);
        }
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        q.add(new Pair<>("0000",0));
        seen.add("0000");
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair<String,Integer> p = q.remove();
                String s = p.getKey();
                int steps = p.getValue();
                if(s.equals(target)) return steps; 
                for(int j=0;j<s.length();j++){
                    StringBuilder sb = new StringBuilder(s);
                    char c = s.charAt(j);
                    char r1 = c=='9'?'0':(char)(c+1);
                    sb.replace(j,j+1,r1+"");
                    if(!seen.contains(sb.toString())){
                        seen.add(sb.toString());
                        q.add(new Pair<>(sb.toString(),steps+1));
                    }
                    char r2 = c=='0'?'9':(char)(c-1);
                    sb.replace(j,j+1,r2+"");
                    if(!seen.contains(sb.toString())){
                        seen.add(sb.toString());
                        q.add(new Pair<>(sb.toString(),steps+1));
                    }
                }
            }
        }
        return -1;
    }
}