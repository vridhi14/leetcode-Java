import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Count fresh & push rotten
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges
        if (fresh == 0) return 0;

        int time = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                for (int[] d : dir) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.offer(new int[]{r, c});
                        fresh--;
                        rotted = true;
                    }
                }
            }

            if (rotted) time++;
        }

        return fresh == 0 ? time : -1;
    }
}