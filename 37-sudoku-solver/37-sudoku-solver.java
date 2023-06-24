class Pair{
    int i;
    int j;
    public Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    int N = 9;
    HashSet<Character>[] rows = new HashSet[N];
    HashSet<Character>[] cols = new HashSet[N];
    HashSet<Character>[] boxes = new HashSet[N];
    boolean solved = false;
    public void solveSudoku(char[][] board) {
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]=='.') {
                    continue;
                }
                rows[i].add(board[i][j]);
                cols[j].add(board[i][j]);
                int idx = (i/3)*3+j/3;
                boxes[idx].add(board[i][j]);   
            }
        }
        backtrack(board,0,0);
    }
    public void backtrack(char[][] board, int i, int j){
        if(i==board.length||j==board.length) {
            solved = true;
            return;
        }
        if(board[i][j]=='.'){
            int idx = (i/3)*3+j/3;
            for(int n=1;n<=9;n++){
                char c = (""+n).charAt(0);
                boolean inRow = rows[i].contains(c);
                boolean inCol = cols[j].contains(c);
                boolean inBox = boxes[idx].contains(c);
                if(!inRow&&!inCol&&!inBox) {
                    board[i][j] = c;
                    rows[i].add(c);
                    cols[j].add(c);
                    boxes[idx].add(c);
                    if(j==board.length-1){
                        backtrack(board,i+1,0);
                    }else {
                        backtrack(board,i,j+1);
                    }
                    if(!solved){
                        board[i][j] = '.';
                        rows[i].remove(c);
                        cols[j].remove(c);
                        boxes[idx].remove(c);    
                    }
                    
                }
            }
        }else {
            if(j==board.length-1){
                backtrack(board,i+1,0);
            }else {
                backtrack(board,i,j+1);
            }
        }
        
    }
    public boolean valid(int i, int j){
        if(i>8||i<0||j>8||j<0) return false;
        return true;
    }
}