class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> rows = new ArrayList<>();
        ArrayList<HashSet<Character>> cols = new ArrayList<>();
        ArrayList<HashSet<Character>> subboxes = new ArrayList<>();
        subboxes.add(new HashSet<>());
        subboxes.add(new HashSet<>());
        subboxes.add(new HashSet<>());
        subboxes.add(new HashSet<>());
        subboxes.add(new HashSet<>());
        subboxes.add(new HashSet<>());
        subboxes.add(new HashSet<>());
        subboxes.add(new HashSet<>());
        subboxes.add(new HashSet<>());
        for(int i=0;i<board.length;i++){
            if(rows.size()==i){
                HashSet row = new HashSet<>();
                rows.add(row);
            }
            for(int j=0;j<board[i].length;j++){
                if(cols.size()==j){
                    HashSet col = new HashSet<>();
                    cols.add(col);
                }
                if(board[i][j]=='.') continue;
                if(rows.get(i).contains(board[i][j])) return false;
                rows.get(i).add(board[i][j]);
                if(cols.get(j).contains(board[i][j])) return false;
                cols.get(j).add(board[i][j]);
                int subbox = getSubboxIndex(i,j);
                if(subboxes.get(subbox).contains(board[i][j])) return false;
                subboxes.get(subbox).add(board[i][j]);
            } 
        }
        return true;
    }
    public int getSubboxIndex(int i, int j){
        if(i<3){
            if(j<3){
                return 0;
            }else if(j<6){
                return 1;
            }else{
                return 2;
            }
        }else if(i<6){
            if(j<3){
                return 3;
            }else if(j<6){
                return 4;
            }else{
                return 5;
            }
        }else{
            if(j<3){
                return 6;
            }else if(j<6){
                return 7;
            }else{
                return 8;
            }
        }
    }
}