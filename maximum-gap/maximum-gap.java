class Solution {
    private static final int NUM_DIGITS = 10;
    public int maximumGap(int[] nums) {
        radixSort(nums);
        int max = 0;
        for(int i=1;i<nums.length;i++){
            max=Math.max(max,nums[i]-nums[i-1]);
        }
        return max;
    }

    public void countingSort(int[] arr, int placeVal) {
        int[] counts = new int[10];

        for (int elem : arr) {
            int current = elem / placeVal;
            counts[current % NUM_DIGITS] += 1;
        }

        int startingIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        int[] sortedArray = new int[arr.length];
        for (int elem : arr) {
            int current = elem / placeVal;
            sortedArray[counts[current % NUM_DIGITS]] = elem;
            counts[current % NUM_DIGITS] += 1;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }
    }

    public void radixSort(int[] arr) {
        int maxElem = Integer.MIN_VALUE;
        for (int elem : arr) {
            if (elem > maxElem) {
                maxElem = elem;
            }
        }

        int placeVal = 1;
        while (maxElem / placeVal > 0) {
            countingSort(arr, placeVal);
            placeVal *= 10;
        }
    }
}
