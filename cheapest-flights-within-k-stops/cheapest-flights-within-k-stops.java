class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,ArrayList<int[]>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i,new ArrayList<>());
        for(int[] flight: flights){
            map.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int[] arr = new int[n];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[src]=0;
        k++;
        while(!q.isEmpty()&&k>0){
            int size = q.size();
            int[] arr2 = arr.clone();
            for(int i=0;i<size;i++){
                int node = q.remove();
                for(int[] flight: map.get(node)){
                    int path = arr[node]+flight[1];
                    if(path<arr2[flight[0]]){
                        q.add(flight[0]);
                        arr2[flight[0]]=path;
                    }
                }
            }
            arr=arr2;
            k--;
        }
        return arr[dst]==Integer.MAX_VALUE?-1:arr[dst];
    }
}