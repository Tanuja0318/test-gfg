class Solution {
    public int diameter(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int farthestNode = bfs(0, adj, V)[0];
        int diameter = bfs(farthestNode, adj, V)[1];
        return diameter;
    }
    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj, int V) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        q.add(start);
        visited[start] = true;
        int farthestNode = start;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                    if (dist[nei] > dist[farthestNode]) {
                        farthestNode = nei;
                    }
                }
            }
        }
        return new int[]{farthestNode, dist[farthestNode]};
    }
}