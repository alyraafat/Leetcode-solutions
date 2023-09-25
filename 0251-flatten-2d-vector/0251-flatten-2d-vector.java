class Vector2D {
    int[][] vec;
    int i,j;
    public Vector2D(int[][] vec) {
        this.vec = vec;
    }
    
    public int next() {
        int num=vec[i][j];
        j++;
        while(i<vec.length&&j>=vec[i].length){
            i++;
            j=0;
        }
        return num;
    }
    
    public boolean hasNext() {
        while(i<vec.length&&j>=vec[i].length){
            i++;
            j=0;
        }
        if(i==vec.length){
            return false;
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */