class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        int E = edges.length;
        int maxPossibleEdges = V * (V - 1) / 2;
        return maxPossibleEdges - E;
    }
}