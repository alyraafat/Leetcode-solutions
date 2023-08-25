class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String[]> lets = new ArrayList<>();
        ArrayList<String[]> digs = new ArrayList<>();
        for(String s: logs){
            String[] split = s.split(" ",2);
            if(split[1].charAt(0)>='0'&&split[1].charAt(0)<='9'){
                digs.add(split);
            }else{
                lets.add(split);
            }
        }
        Collections.sort(lets,new Comparator<String[]>() {
            @Override
            public int compare(String[] s1,String[] s2) {
                if(s1[1].compareTo(s2[1])==0){
                    return s1[0].compareTo(s2[0]);
                }else{
                    return s1[1].compareTo(s2[1]);
                }
            }
        });
        String[] ans = new String[logs.length];
        int i=0;
        for(String s[]: lets){
            ans[i]=s[0]+" "+s[1];
            i++;
        }
        for(String s[]: digs){
            ans[i]=s[0]+" "+s[1];
            i++;
        }
        return ans;
    }
}