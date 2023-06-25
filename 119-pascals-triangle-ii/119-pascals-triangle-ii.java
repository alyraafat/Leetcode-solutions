class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        if(rowIndex == 0){
            return row;
        }else if(rowIndex == 1){
            row.add(1);
            return row;
        }
        row.add(1);
        for(int i=2;i<=rowIndex;i++){
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            newRow.add(1);
            for(int j=0;j<row.size()-1;j++){
                newRow.add(row.get(j)+row.get(j+1));
            }
            newRow.add(1);
            row = newRow;
        }
        return row;
    }
}