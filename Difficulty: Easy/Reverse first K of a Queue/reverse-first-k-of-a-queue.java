class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if (q == null || k <= 0 || k > q.size()) return q;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }
        int remaining = q.size() - k;
        for (int i = 0; i < remaining; i++) {
            q.offer(q.poll());
        }
        return q;
    }
}