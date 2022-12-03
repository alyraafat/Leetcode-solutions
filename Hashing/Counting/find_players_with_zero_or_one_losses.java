//You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.

//Return a list answer of size 2 where:
//  1-answer[0] is a list of all players that have not lost any matches.
//  2-answer[1] is a list of all players that have lost exactly one match.
//The values in the two lists should be returned in increasing order.

//Note:
//  1-You should only consider the players that have played at least one match.
//  2-The testcases will be generated such that no two matches will have the same outcome.

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> win = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> lose = new HashMap<Integer,Integer>();
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        for(int i=0;i<matches.length;i++){
            for(int j=0;j<matches[i].length;j++){
                if(j==0) {
                    win.put(matches[i][j],win.getOrDefault(matches[i][j],0)+1);
                    lose.put(matches[i][j],lose.getOrDefault(matches[i][j],0));
                }
                else {
                    win.put(matches[i][j],win.getOrDefault(matches[i][j],0));
                    lose.put(matches[i][j],lose.getOrDefault(matches[i][j],0)+1);
                }
            }
        }
        // for (int key: lose.keySet()) {
        //     System.out.println(String.format(""+ key+":"+ lose.get(key)));
        // }
        List<Integer> l0 = new ArrayList<Integer>();
        List<Integer> l1 = new ArrayList<Integer>();
        for(int k: lose.keySet()){
            if(lose.get(k)==0) l0.add(k);
            if(lose.get(k)==1) l1.add(k);
        }
        l.add(l0);
        l.add(l1);
        return l;
    }
}
