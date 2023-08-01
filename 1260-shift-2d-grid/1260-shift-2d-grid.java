class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        k=k%(m*n);
        // System.out.println(k);
        for(int i=0;i<k;i++){
            int temp=grid[0][0];
            for(int j=0;j<m;j++){
                if(j>0){
                    int x = temp;
                    temp=grid[j][0];
                    grid[j][0]=x;
                }
                for(int z=1;z<n;z++){
                    int temp2=temp;
                    temp=grid[j][z];
                    grid[j][z]=temp2;
                }
            }
            grid[0][0]=temp;
        }
        ArrayList<List<Integer>> ans =new ArrayList<>();
        for(int j=0;j<m;j++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int z=0;z<n;z++){
                temp.add(grid[j][z]);
            }
            ans.add(temp);
        }
        return ans;
    }
}