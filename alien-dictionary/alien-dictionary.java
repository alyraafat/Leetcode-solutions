class Solution {
    HashMap<Character, ArrayList<Character>> map;
    public String alienOrder(String[] words) {
        map = new HashMap<>();
        char c = 'a';
        for(int i=0;i<26;i++){
            char curr = (char)(c+i);
            map.put(curr,new ArrayList<>());
        }
        HashSet<Character> found = new HashSet<>();
        char[] alphabet = new char[26];
        for(int i=0;i<words.length-1;i++){
            String curr = words[i];
            String next = words[i+1];
            int min = Math.min(curr.length(),next.length());
            boolean flag = false;
            if (curr.length() > next.length() && curr.startsWith(next)) {
                return "";
            }
            for(int j=0;j<min;j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                found.add(c1);
                found.add(c2);
                if(c1!=c2&&!flag){
                    map.get(c1).add(c2);
                    alphabet[c2-'a']++;
                    flag=true;
                }
            }
            
            int max = Math.max(curr.length(),next.length());
            if(curr.length()>next.length()){
                for(int j=min;j<max;j++) {
                    found.add(curr.charAt(j));
                }
            }else{
                for(int j=min;j<max;j++) {
                    found.add(next.charAt(j));
                }
            }
        }
        if(words.length==1){
            for(int i=0;i<words[0].length();i++){
                found.add(words[0].charAt(i));
            }
        }
        StringBuilder top = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<26;i++){
            char c1 = (char)(c+i);
            if(alphabet[i]==0&&found.contains(c1)){
                q.add(c1);
            }
        }
        while(!q.isEmpty()){
            char curr = q.poll();
            top.append(curr+"");
            for(char c1: map.get(curr)){
                alphabet[c1-'a']--;
                if(alphabet[c1-'a']==0) q.add(c1);
            }
        }
        if(top.length()<found.size()) return "";
        return top.toString();
    }
}