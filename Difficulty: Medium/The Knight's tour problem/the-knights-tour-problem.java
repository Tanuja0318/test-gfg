class Solution {
    private static final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], -1);
        }
        board[0][0] = 0; 
        if (solve(board, 0, 0, 1, n)) {
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(board[i][j]);
                }
                result.add(row);
            }
        }
        return result;
    }
    private boolean solve(int[][] board, int x, int y, int moveCount, int n) {
        if (moveCount == n * n) return true; 
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (isValid(nx, ny, n, board)) {
                board[nx][ny] = moveCount;
                if (solve(board, nx, ny, moveCount + 1, n)) return true;
                board[nx][ny] = -1; 
            }
        }
        return false;
    }
    private boolean isValid(int x, int y, int n, int[][] board) {
        return (x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1);
    }
}