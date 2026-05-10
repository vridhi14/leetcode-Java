class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // STEP 1:
        // Traverse boundary cells

        for (int i = 0; i < m; i++) {

            // first column
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }

            // last column
            if (grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {

            // first row
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }

            // last row
            if (grid[m - 1][j] == 1) {
                dfs(grid, m - 1, j);
            }
        }

        // STEP 2:
        // Count remaining land cells

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int r, int c) {

        int m = grid.length;
        int n = grid[0].length;

        // out of bounds
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return;
        }

        // water or already visited
        if (grid[r][c] == 0) {
            return;
        }

        // mark visited
        grid[r][c] = 0;

        // explore 4 directions
        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            dfs(grid, nr, nc);
        }
    }
}