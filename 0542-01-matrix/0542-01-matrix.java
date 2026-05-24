class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Directions
        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Step 1:
        // Put all 0s into queue
        // Mark 1s as unvisited (-1)

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }

                else {
                    mat[i][j] = -1;
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                // Valid and unvisited
                if (nr >= 0 && nc >= 0 &&
                    nr < rows && nc < cols &&
                    mat[nr][nc] == -1) {

                    mat[nr][nc] = mat[r][c] + 1;

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return mat;
    }
}