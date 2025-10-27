class Solution {
    static class Pair {
        int i, j, sum;
        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || k == 0)
            return result;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        for (int i = 0; i < Math.min(arr1.length, k); i++) {
            pq.offer(new Pair(i, 0, arr1[i] + arr2[0]));
        }
        while (k-- > 0 && !pq.isEmpty()) {
            Pair cur = pq.poll();
            int i = cur.i, j = cur.j;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arr1[i]);
            temp.add(arr2[j]);
            result.add(temp);
            if (j + 1 < arr2.length) {
                pq.offer(new Pair(i, j + 1, arr1[i] + arr2[j + 1]));
            }
        }
        return result;
    }
}
