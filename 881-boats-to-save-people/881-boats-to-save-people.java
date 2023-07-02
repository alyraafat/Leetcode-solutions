class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        // int i=0;
        // int j=0;
        // int ans=0;
        // int count = 0;
        // int sum = 0;
        // while(j<people.length){ 
        //     sum+=people[j];
        //     count++;
        //     if(count<2&&sum<=limit){
        //         j++;
        //     }else if(count<=2&&sum<=limit){
        //         ans+=1;
        //         j++;
        //         i=j;
        //         count=0;
        //         sum=0;
        //     }else if(count==2&&sum>limit){
        //         ans+=1;
        //         sum-=people[i];
        //         i=j;
        //         j++;
        //         count=1;
        //     }else if(count==1&&sum>limit){
        //         sum=0;
        //         i++;
        //         j++;
        //         sum=0;
        //         count=0;
        //     }
        // }
        // if((sum>0&&sum<=limit)&&(count==1||count==2)) ans+=1;
        int ans=0;
        int i=0;
        int j=people.length-1;
        if(people[i]>limit) return 0;
        while(i<j){
            if(people[i]+people[j]<=limit){
                i++;
                j--;
                ans+=1;
            }else if(people[j]<=limit){
                ans+=1;
                j--;
            }else if(people[i]>limit) break;
        }
        if(i==j && people[j]<=limit) ans+=1;

        return ans;
    }
}