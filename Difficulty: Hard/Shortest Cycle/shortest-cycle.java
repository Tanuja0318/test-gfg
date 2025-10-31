class Solution {
    public int shortCycle(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) 
            graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int shortest = Integer.MAX_VALUE;
        for (int start = 0; start < V; start++) {
            int[] dist = new int[V];
            int[] parent = new int[V];
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            dist[start] = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neigh : graph.get(node)) {
                    if (dist[neigh] == -1) {
                        dist[neigh] = dist[node] + 1;
                        parent[neigh] = node;
                        queue.add(neigh);
                    }
                    else if (parent[node] != neigh) {
                        shortest = Math.min(shortest, dist[node] + dist[neigh] + 1);
                    }
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}