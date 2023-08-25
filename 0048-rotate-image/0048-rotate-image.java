class Solution {
    public void rotate(int[][] matrix) {
        int i=0;
        int n = matrix.length;
        int shift = n-1;
        int j=0;
        int k=0;
        while(i<n*n&&shift>0){
            int c=1;
            while(c<=shift){
                shiftMat(matrix,j,k+c-1,shift,j,k,j+shift,k+shift);
                i+=4;
                c++;
            }
            shift-=2;
            j++;
            k++;
        }
    }
    public void shiftMat(int[][] matrix, int i,int j,int shift, int startI,int startJ,int endI,int endJ){
        int j2 = Math.min(j+shift,endJ);
        int i2 = i;
        if(j+shift>endJ){
            i2 += (j+shift)-endJ;
        }
        int temp = matrix[i2][j2];
        matrix[i2][j2] = matrix[i][j];
        i=i2;
        j=j2;
        
        i2 = Math.min(i+shift,endI);
        j2 = j;
        if(i+shift>endI){
            j2 -= i+shift-endI;
        }
        int temp1 = matrix[i2][j2];
        matrix[i2][j2] = temp;
        temp = temp1;
        i=i2;
        j=j2;
        
        j2 = Math.max(j-shift,startJ);
        i2 = i;
        if(j-shift<startJ){
            i2 -= startJ-(j-shift);
        }
        temp1 = matrix[i2][j2];
        matrix[i2][j2] = temp;
        temp = temp1;
        i=i2;
        j=j2;
        
        i2 = Math.max(i-shift,startI);
        j2 = j;
        if(i-shift<startI){
            j2 += startI-(i-shift);
        }
        matrix[i2][j2] = temp;
    }
}