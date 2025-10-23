class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k)
                maxHeap.poll(); 
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] p = maxHeap.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(p[0]);
            temp.add(p[1]);
            result.add(temp);
        }
        return result;
    }
}