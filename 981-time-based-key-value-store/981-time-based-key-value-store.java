class TimeMap {
    HashMap<String,ArrayList<Pair<String,Integer>>> map;
    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Pair<String,Integer>> arr = map.getOrDefault(key,new ArrayList<>());
        arr.add(new Pair<>(value,timestamp));
        map.put(key,arr);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Pair<String,Integer>> arr = map.get(key);
        if(arr==null||arr.size()==0) return "";
        int left=0;
        int right=arr.size()-1;
        String value = "";
        int min = -1;
        while(left<=right){
            int mid=left+(right-left)/2;
            Pair<String,Integer> curr = arr.get(mid);
            int t = curr.getValue();
            if(t<timestamp){
                if(t>min){
                    min=t;
                    value=curr.getKey();
                }
                left=mid+1;
            }else if(t>timestamp){
                right=mid-1;
            }else{
                return curr.getKey();
            }
        }
        return value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */