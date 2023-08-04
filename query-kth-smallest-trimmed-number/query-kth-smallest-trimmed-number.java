class Solution {
    final int NUM_DIGITS=10;
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            ArrayList<Integer> a = map.getOrDefault(nums[i],new ArrayList<>());
            a.add(i);
            map.put(nums[i],a);
        }
        for(int i=0;i<queries.length;i++){
            int[] query=queries[i];
            String[] copy = nums.clone();
            radixSort(copy,query[1]);
            ArrayList<Integer> indices = map.get(copy[query[0]-1]);
            int z=0;
            if(indices.size()>1){
                z = getDups(copy,query[0]-1);
            }
            ans[i]=indices.get(z);
        }
        return ans;
    }
    public int getDups(String[] copy, int i){
        int moves=0;
        int j=i-1;
        while(j>=0){
            if(copy[j].equals(copy[i])) moves++;
            else break;
            j--;
        }
        return moves;
    }
    public void countingSort(String[] arr, int placeVal) {
        
        int[] counts = new int[NUM_DIGITS];

        for (String elem : arr) {
            int current = Integer.parseInt(""+elem.charAt(elem.length()-placeVal));
            counts[current] ++;
        }

        int startingIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        String[] sortedArray = new String[arr.length];
        for (String elem : arr) {
            int current = Integer.parseInt(""+elem.charAt(elem.length()-placeVal));
            sortedArray[counts[current]] = elem;
            counts[current] ++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }

    public void radixSort(String[] arr,int limit) {
        int placeVal = 1;
        while (placeVal<=limit) {
            countingSort(arr, placeVal);
            placeVal ++;
        }
    }
}

