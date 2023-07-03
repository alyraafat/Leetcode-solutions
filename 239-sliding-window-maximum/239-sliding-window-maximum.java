class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int i=0;int j=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while(j<nums.length){
            if((j-i+1)<=k){
                pq.add(nums[j]);
                j++;
            }else if((j-i+1)>k){
                ans[i] = pq.peek(); 
                int prev = nums[i];
                map.put(prev,map.getOrDefault(prev,0)+1);
                int top = pq.peek();
                if(pq.peek()==prev) {
                    pq.poll();
                    map.put(top,map.getOrDefault(top,0)-1);
                    if(map.get(top)<=0) map.remove(top);
                }
                i++;
                while(!pq.isEmpty()&&map.containsKey(pq.peek())&&map.get(pq.peek())>0){
                    top=pq.peek();
                    pq.poll();
                    map.put(top,map.getOrDefault(top,0)-1);
                    if(map.get(top)==0) map.remove(top);
                }
            }
        }
        ans[i] = pq.peek();
        return ans;
    }
    
}