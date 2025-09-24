class SpecialQueue {
    
    private Queue<Integer> q;         
    private Deque<Integer> minDeque;   
    private Deque<Integer> maxDeque;   
    public SpecialQueue() {
        q = new LinkedList<>();
        minDeque = new ArrayDeque<>();
        maxDeque = new ArrayDeque<>();
    }
    public void enqueue(int x) {
        q.offer(x);
        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.pollLast();
        }
        minDeque.offerLast(x);
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(x);
    }
    public void dequeue() {
        if (q.isEmpty()) return;
        int front = q.poll();
        if (!minDeque.isEmpty() && front == minDeque.peekFirst()) {
            minDeque.pollFirst();
        }
        if (!maxDeque.isEmpty() && front == maxDeque.peekFirst()) {
            maxDeque.pollFirst();
        }
    }
    public int getFront() {
        return q.peek();
    }
    public int getMin() {
        return minDeque.peekFirst();
    }
    public int getMax() {
        return maxDeque.peekFirst();
    }
}