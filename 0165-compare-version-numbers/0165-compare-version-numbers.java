class Solution {
    public int compareVersion(String version1, String version2) {
        int ans = 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int min = Math.min(v1.length,v2.length);
        for(int i=0;i<min;i++){
            int a1 = Integer.parseInt(v1[i]);
            int a2 = Integer.parseInt(v2[i]);
            if(a1<a2){
                ans=-1;
                break;
            }else if(a1>a2){
                ans=1;
                break;
            }
        }
        if(ans==0){
            int max = Math.max(v1.length,v2.length);
            String[] temp = v1.length>v2.length?v1:v2;
            boolean one = v1.length>v2.length?true:false;
            for(int i=min;i<max;i++){
                int a = Integer.parseInt(temp[i]);
                if(a>0){
                    ans = one?1:-1;
                    break;
                }
            }
        }
        return ans;
    }
    
}