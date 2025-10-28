class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                temp.add(dist[i][j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}