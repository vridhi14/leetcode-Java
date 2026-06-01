import java.util.*;

class Solution {

    class Pair {
        int effort;
        int row;
        int col;

        Pair(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        effort[0][0] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.effort - b.effort);

        pq.offer(new Pair(0, 0, 0));

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int currEffort = curr.effort;
            int r = curr.row;
            int c = curr.col;

            if (r == m - 1 && c == n - 1) {
                return currEffort;
            }

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {

                    int edgeCost =
                            Math.abs(heights[r][c] - heights[nr][nc]);

                    int newEffort =
                            Math.max(currEffort, edgeCost);

                    if (newEffort < effort[nr][nc]) {

                        effort[nr][nc] = newEffort;

                        pq.offer(new Pair(newEffort, nr, nc));
                    }
                }
            }
        }

        return 0;
    }
}