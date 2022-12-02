//Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. If there are duplicates in arr, count them separately.

class Solution {
    public int countElements(int[] arr) {
        int x = 0;
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            if(m.containsKey(arr[i])){
                m.put(arr[i],m.get(arr[i])+1);
            }else{
                m.put(arr[i],1);
            }
            
        }
        for(int key : m.keySet()){
            if(m.containsKey(key+1)){
                x+=m.get(key);
            }
        }
        return x;
    }
}
