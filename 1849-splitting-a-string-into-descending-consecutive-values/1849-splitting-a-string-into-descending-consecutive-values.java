class Solution {
    boolean flag;
    public boolean splitString(String s) {
        int i=0;
        for(;i<s.length();i++){
            if(s.charAt(i)!=0) break;
        }
        backtrack(new StringBuilder(s),new ArrayList<>(),i);
        return flag;
    }
    public void backtrack(StringBuilder s,ArrayList<Long> curr,int i){
        if(flag) return;
        if(curr.size()>0&&i==s.length()){
            boolean currFlag = true;
            for(int j=1;j<curr.size();j++){
                long num = curr.get(j);
                long prev = curr.get(j-1);
                long diff = prev-num;
                if(diff!=1) {
                    currFlag=false;
                    break;
                } 
            }
            if(curr.size()>1&&currFlag) flag = true;
            // flag=true;
            return;
        }
        StringBuilder t = new StringBuilder();
        for(int k=i;k<s.length();k++){
            char c = s.charAt(k);
            t.append(c);
            try{
                long currNum = Long.parseLong(t.toString());
                // if(curr.size()>0&&curr.get(curr.size()-1)-currNum!=1) return;
                curr.add(currNum);
                backtrack(s,curr,k+1);
                if(flag) return;
                curr.remove(curr.size()-1);
            }catch(Exception e){
                return;
            } 
        }
    }
}