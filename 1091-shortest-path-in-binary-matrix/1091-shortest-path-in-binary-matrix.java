class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length ; 
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1 ; 
        }
        int[][] directions = { 
            {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
        };
        Queue<int[]> q = new LinkedList<>();
        // queue = row, col , distance 
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1 ; // mark visited 
        while(!q.isEmpty()){
            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            if(row == n-1 && col == n-1) return dist ; 

            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr>=0 && nc >= 0 && nc<n && nr<n && grid[nr][nc] == 0) {
                    q.offer(new int[]{nr, nc , dist + 1});
                    grid[nr][nc] = 1 ; // visited
                }
            }
        }
        return -1  ; 
    }
}