class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[1] == a[1]) return b[0] - a[0]; 
            return b[1] - a[1]; 
        });
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            ans.add(pq.poll()[0]);
        }
        return ans;
    }
}
