class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        // char[] c = p.toCharArray();
        // Arrays.sort(c);
        // String x = new String(c);
        if(s.length()<p.length()) return ans;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++) {
            int k = map.getOrDefault(p.charAt(i),0)+1;
            map.put(p.charAt(i),k);
        }
        
        HashMap<Character,Integer> m = new HashMap<>();
        int j=0;
        
        while(j<p.length()){
            char curr = s.charAt(j);
            // if(!((map.keySet()).contains(curr))||(m.get(curr)!=null&&map.get(curr)>m.get(curr))){
            //     i=j;
            //     break;
            // }else{
            int k = m.getOrDefault(curr,0)+1;
            m.put(curr,k);
            // }
            j++;
        }
        // System.out.println("map:"+map);
        // System.out.println("m:"+m);
        boolean equal =true;
        for(char c1: map.keySet()){
            // System.out.println(c1);
            // System.out.println(map.get(c1).equals(m.get(c1)));
            // System.out.println(map.get(c1)!=m.get(c1));
            if(m.get(c1)==null||!map.get(c1).equals(m.get(c1))){
                equal = false;
                break;
            }
        }
        // System.out.println(equal);
        if(equal) ans.add(0);
        for(int i=1;i<=s.length()-p.length();i++){
            char prev = s.charAt(i-1);
            m.put(prev,m.get(prev)-1);
            if(m.get(prev)==0) m.remove(prev);
            m.put(s.charAt(i-1+p.length()),m.getOrDefault(s.charAt(i-1+p.length()),0)+1);
            equal = true;
            for(char c1: map.keySet()){
                if(m.get(c1)==null||!map.get(c1).equals(m.get(c1))){
                    equal = false;
                    break;
                }
            }
            if(equal) ans.add(i);
        }
        return ans;
    }
}