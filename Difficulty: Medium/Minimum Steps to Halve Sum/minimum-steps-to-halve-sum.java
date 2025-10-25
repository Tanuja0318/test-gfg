class Solution {
    public int minOperations(int[] arr) {
        double total = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            total += num;
            maxHeap.offer((double) num);
        }
        double target = total / 2.0;
        double reduced = 0;
        int steps = 0;
        while (reduced < target) {
            double max = maxHeap.poll();    
            double half = max / 2.0;         
            reduced += half;            
            maxHeap.offer(half);            
            steps++;
        }
        return steps;
    }
}