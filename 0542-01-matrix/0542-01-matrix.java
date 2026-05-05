import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Initialize
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // Directions: up, down, left, right
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                
                // Check bounds
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    
                    // Relaxation step
                    if (mat[nr][nc] > mat[r][c] + 1) {
                        mat[nr][nc] = mat[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return mat;
    }
}