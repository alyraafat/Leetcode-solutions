class TicTacToe {
    HashMap<Integer,HashMap<Integer,Integer>> rows;
    HashMap<Integer,HashMap<Integer,Integer>> cols;
    HashMap<Integer,Integer> diags;
    HashMap<Integer,Integer> antidiags;
    int n;
    public TicTacToe(int n) {
        this.n = n;
        this.rows = new HashMap<>();
        this.cols = new HashMap<>();
        this.diags = new HashMap<>();
        this.antidiags = new HashMap<>();
    }
    
    public int move(int row, int col, int player) {
        HashMap<Integer,Integer> currRow = this.rows.getOrDefault(row,new HashMap<>());
        currRow.put(player,currRow.getOrDefault(player,0)+1);
        this.rows.put(row,currRow);
        if(currRow.get(player)==this.n) return player;
        
        HashMap<Integer,Integer> currCol = this.cols.getOrDefault(col,new HashMap<>());
        currCol.put(player,currCol.getOrDefault(player,0)+1);
        this.cols.put(col,currCol);
        if(currCol.get(player)==this.n) return player;
        
        if(row-col==0){
            this.diags.put(player,this.diags.getOrDefault(player,0)+1);
            if(this.diags.get(player)==this.n) return player;
        }
        
        if(row+col==this.n-1){
            this.antidiags.put(player,this.antidiags.getOrDefault(player,0)+1);
            if(this.antidiags.get(player)==this.n) return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */