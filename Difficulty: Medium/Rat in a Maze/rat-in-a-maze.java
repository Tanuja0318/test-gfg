class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) 
            return res;
        boolean[][] visited = new boolean[n][n];
        backtrack(0, 0, maze, n, visited, "", res);
        Collections.sort(res); 
        return res;
    }
    private void backtrack(int i, int j, int[][] maze, int n, boolean[][] visited,
                           String path, ArrayList<String> res) {
        if (i == n - 1 && j == n - 1) {
            res.add(path);
            return;
        }
        visited[i][j] = true;
        if (isSafe(i + 1, j, maze, n, visited)) {
            backtrack(i + 1, j, maze, n, visited, path + "D", res);
        }
        if (isSafe(i, j - 1, maze, n, visited)) {
            backtrack(i, j - 1, maze, n, visited, path + "L", res);
        }
        if (isSafe(i, j + 1, maze, n, visited)) {
            backtrack(i, j + 1, maze, n, visited, path + "R", res);
        }
        if (isSafe(i - 1, j, maze, n, visited)) {
            backtrack(i - 1, j, maze, n, visited, path + "U", res);
        }
        visited[i][j] = false;
    }
    private boolean isSafe(int i, int j, int[][] maze, int n, boolean[][] visited) {
        return (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && !visited[i][j]);
    }
}