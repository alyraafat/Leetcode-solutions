class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int pile: piles){
            max=Math.max(pile,max);
        }
        int k = max;
        int min=1;
        while(min<=max){
            int mid = min+(max-min)/2;
            int x=0;
            for(int pile: piles){
                double d= (double)(pile)/mid; 
                x+=Math.ceil(d);
            }   
            if(x>h){
                min=mid+1;
            }else{
                k=Math.min(k,mid);
                max=mid-1;
            }
        }
        return k;
    }
}