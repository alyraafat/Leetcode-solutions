class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        countingSort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            minDiff=Math.min(minDiff,arr[i]-arr[i-1]);
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==minDiff){
                ArrayList<Integer> a = new ArrayList<>();
                a.add(arr[i-1]);
                a.add(arr[i]);
                ans.add(a);
            }
        }
        return ans;
    }
    public void countingSort(int[] arr) {
        int shift = Arrays.stream(arr).min().getAsInt();
        int K = Arrays.stream(arr).max().getAsInt() - shift;
        int[] counts = new int[K + 1];
        for (int elem : arr) {
            counts[elem - shift] += 1;
        }

        int startingIndex = 0;
        for (int i = 0; i < K + 1; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int sortedArray[] = new int[arr.length];
        for (int elem : arr) {
            sortedArray[counts[elem - shift]] = elem;
            counts[elem - shift] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }

}