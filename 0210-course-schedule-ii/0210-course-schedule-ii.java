class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for (int[] list : prerequisites) {
            indegree[list[0]]++;
            ArrayList<Integer> arr = map.getOrDefault(list[1],new ArrayList<>());
            arr.add(list[0]);
            map.put(list[1],arr);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) {
                q.add(i);
                ans.add(i);
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int j=0;j<size;j++){
                int curr = q.poll();
                if(!map.containsKey(curr)) continue;
                for(int c: map.get(curr)){
                    indegree[c]--;
                    if(indegree[c]==0) {
                        q.add(c);
                        ans.add(c);
                    }
                }
                
            }
        }
        if(ans.size()<numCourses) return new int[]{};
        int[] ans2 = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ans2[i] = ans.get(i);
        }
        return ans2;
    }
}