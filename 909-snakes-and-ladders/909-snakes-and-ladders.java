class Solution {
    public int snakesAndLadders(int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int n = board.length;
        HashSet<Integer> seen = new HashSet<>();
        // for(int j=1;j<=n*n;j++){
        //     int[] z =  index(j,n);
        //     System.out.println(j+",row:"+z[0]+",col:"+z[1]);
        // }
        q.add(new int[]{1,0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.remove();
                if(curr[0]==n*n) return curr[1];
                int start = curr[0]+1;
                int end = Math.min(n*n,curr[0]+6);
                for(int j=start;j<=end;j++){
                    if(seen.contains(j)) continue;
                    int[] coord = index(j,n);
                    int row = coord[0];
                    int col = coord[1];
                    seen.add(j);
                    int[] added = new int[]{j,curr[1]+1};
                    if(board[row][col]!=-1){
                        added[0] = board[row][col];
                    }
                    q.add(added);
                }
            }
        }
        return -1;
    }
    public int[] index(int num, int n){
        int[] i = new int[2];
        int rem = num%n;
        i[0] = rem==0?(n==num?n-1:n-1-((num/n)-1)):n-1-num/n;
        if(n%2==0){//odd=left, even=right
            if(i[0]%2==0){
                i[1] = rem==0?0:n-rem;
            }else{
                i[1] = rem==0?n-1:rem-1;
            }
        }else{
            if(i[0]%2==0){
                i[1] = rem==0?n-1:rem-1;
            }else{
                i[1] = rem==0?0:n-rem;
            }
        }
        return i;
    }
}