class Solution {
    public String intToRoman(int num) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        String ans="";
        int i = 0;
        int k = num;
        int min = 1;
        int max = 10;
        while(k>0){
            String f = "";
            int rem = k%10;
            int n = rem*(int)Math.pow(10,i);
            int mid = max/2;
            if(map.containsKey(n)){
                f+=map.get(n);
                n=0;
            }
            else if(n>=mid&&map.containsKey(mid)){
                n=n-mid;
                f+=map.get(mid);
            }
            n=n/min;
            while(n>0){
                f+=map.get(min);
                n--;
            }
            ans = f+ans;
            k/=10;
            i++;
            min = max;
            max = max*10;
        }
        return ans;
    }
}