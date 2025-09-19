class Solution {
    public void reverseQueue(Queue<Integer> q) {
        int n=q.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=q.poll();
        }
        for(int i=n-1;i>=0;i--)
            q.offer(res[i]);
    }
}