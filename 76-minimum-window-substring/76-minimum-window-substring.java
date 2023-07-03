class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(t.length()>s.length()) return "";
        for(int i=0;i<t.length();i++){
            char curr = t.charAt(i);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        StringBuilder ans = new StringBuilder();
        int i=0;
        while(i<s.length()){
            char curr = s.charAt(i);
            if(!map.containsKey(curr)) i++;
            else break;
        }
        int j=i;
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> temp = new HashMap<>();
        while(j<s.length()){
            char curr = s.charAt(j);
            if(map.containsKey(curr)&&(temp.get(curr)==null||(temp.get(curr)!=null&&map.get(curr)>temp.get(curr)))){
                temp.put(curr,temp.getOrDefault(curr,0)+1);
                sb.append(curr);
                j++;
                int x=0;
                while(x<sb.length()&&areMapsEqual(map,temp)){
                    StringBuilder tb = new StringBuilder(sb.substring(x,sb.length()));
                    if(map.containsKey(sb.charAt(x))){
                        ans = ans.length()==0||(tb.length()<ans.length()&&ans.length()!=0)?new StringBuilder(tb):ans;
                        temp.put(sb.charAt(x),temp.getOrDefault(sb.charAt(x),0)-1);
                        if(temp.get(sb.charAt(x))<=0) temp.remove(sb.charAt(x));
                    }
                    x++;
                }
                sb.replace(0,x,"");
                // System.out.println(sb.toString());
                i+=x;
            }else if(map.containsKey(curr)&&temp.get(curr)!=null&&map.get(curr)<=temp.get(curr)){
                sb.append(curr);
                temp.put(curr,temp.getOrDefault(curr,0)+1);
                j++;
            }else if(!map.containsKey(curr)){
                if(sb.length()>0) sb.append(curr);
                else i++;
                j++;
            }
        }
        if(j==s.length()&&areMapsEqual(map,temp)){
             ans = ans.length()==0||(sb.length()<ans.length()&&ans.length()!=0)?new StringBuilder(sb):ans;
        }
        return ans.toString();
    }
    public boolean areMapsEqual(HashMap<Character,Integer> map,HashMap<Character,Integer> temp){
        for(char c: map.keySet()){
            if((temp.get(c)==null)||map.get(c).compareTo(temp.get(c))>0) return false;
        }        
        return true;
    }
}