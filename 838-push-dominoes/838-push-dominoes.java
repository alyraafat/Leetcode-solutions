class Solution {
    public String pushDominoes(String dominoes) {
        int i=0;
        int j=dominoes.length()-1;
        if(dominoes.length()==1) return dominoes;
        StringBuilder sb = new StringBuilder(dominoes);
        double mid = sb.length()/2;
        if(sb.length()%2==0){
            mid -= 0.5 ;
        }
        String replace = "";
        while(i<sb.length()){
            if(sb.charAt(i)!='.') break;
            i++;
            replace+="L";
        }
        if(i==sb.length()) return dominoes;
        
        if(sb.charAt(i)=='L'){
            sb.replace(0,i,replace);
        }
        replace = "";
        while(j>=0){
            if(sb.charAt(j)!='.') break;
            j--;
            replace+="R";
        }
        if(sb.charAt(j)=='R'){
            sb.replace(j+1,sb.length(),replace);
        }
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x=i;x<j;x++){
            if(sb.charAt(x)!='.'&&sb.charAt(x+1)=='.') arr.add(x+1);
            if(sb.charAt(x)=='.'&&sb.charAt(x+1)!='.'){
                arr.add(x);
                set.add(new ArrayList<>(arr));
                arr.clear();
            }
        }
        for(ArrayList<Integer> a: set){
            int x=a.get(0);
            int y=a.get(1);
            while(x<y){
                String replaceX = "";
                String replaceY = "";
                boolean xDec = false;
                if(sb.charAt(x)=='.'){
                    char prev = sb.charAt(x-1);
                    char next = sb.charAt(x+1);
                    if(prev=='R'&&(next=='.'||next=='R')) {
                        replaceX = "R";
                    }
                    else if((prev=='.'||prev=='L')&&next=='L') {
                        replaceX = "L";
                    }else if((prev=='.'||prev=='L')&&next=='.'){
                        x--;
                        xDec = true;
                    }
                }
                if(sb.charAt(y)=='.'){
                    char prev = sb.charAt(y-1);
                    char next = sb.charAt(y+1);
                    if(prev=='R'&&(next=='.'||next=='R')) {
                        replaceY="R";
                    }
                    else if((prev=='.'||prev=='L')&&next=='L') {
                        replaceY="L";
                    }
                    else if(!xDec&&prev=='.'&&(next=='.'||next=='R')){
                        y++;
                    }
                }
                if(!replaceX.equals(""))sb.replace(x,x+1,replaceX);
                if(!replaceY.equals(""))sb.replace(y,y+1,replaceY);
                x++;
                y--;
            }
            if(x==y&&sb.charAt(x)=='.'){
                char prev = sb.charAt(x-1);
                char next = sb.charAt(x+1);
                if(prev=='R'&&(next=='.'||next=='R')) sb.replace(x,x+1,"R");
                else if((prev=='.'||prev=='L')&&next=='L') sb.replace(x,x+1,"L");
            }
            
        }
        // boolean[] isChanged = new boolean[sb.length()];
        // while(i<j){
        //     if(sb.charAt(i)=='.'){
        //         char prev = isChanged[i-1]?'.':sb.charAt(i-1);
        //         char next = isChanged[i+1]?'.':sb.charAt(i+1);
        //         if(prev=='R'&&(next=='.'||next=='R')) {
        //             sb.replace(i,i+1,"R");
        //             isChanged[i]=true;
        //         }
        //         else if((prev=='.'||prev=='L')&&next=='L') {
        //             sb.replace(i,i+1,"L");
        //             isChanged[i]=true;
        //         }
        //     }
        //     if(sb.charAt(j)=='.'){
        //         char prev = isChanged[j-1]?'.':sb.charAt(j-1);
        //         char next = isChanged[j+1]?'.':sb.charAt(j+1);
        //         if(prev=='R'&&(next=='.'||next=='R')) {
        //             sb.replace(j,j+1,"R");
        //             isChanged[j]=true;
        //         }
        //         else if((prev=='.'||prev=='L')&&next=='L') {
        //             sb.replace(j,j+1,"L");
        //             isChanged[j]=true;
        //         }
        //     }
        //     i++;
        //     j--;
        // }
        // if(i==j&&sb.charAt(j)=='.'){
        //     char prev = isChanged[j-1]?'.':sb.charAt(j-1);
        //     char next = isChanged[j+1]?'.':sb.charAt(j+1);
        //     if(prev=='R'&&(next=='.'||next=='R')) sb.replace(j,j+1,"R");
        //     else if((prev=='.'||prev=='L')&&next=='L') sb.replace(j,j+1,"L");
        // }
        return sb.toString();
    }
}