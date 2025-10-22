class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;
        for (int i = 0; i < Math.min(k + 1, arr.length); i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 3, 1, 4};
        int k = 2;
        sol.nearlySorted(arr, k);
        System.out.println(Arrays.toString(arr)); 
    }
}
