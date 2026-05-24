import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0 ; 
        int r = grid.length ; 
        int c = grid[0].length ; 
        
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i<r ; i++){
            for(int j = 0 ; j<c ; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++ ; 
                }
            }
        } 
        if(fresh==0) return 0 ; 
        int min = 0 ; 
        int[][] dir = {
            {-1,0},{1,0},{0,-1},{0,1} } ;

            //BFS 
        while(!q.isEmpty()){
            int size = q.size();
            boolean rottenThisMin = false ; 

            for(int i = 0 ; i<size ; i++){
                int[] curr = q.poll();
                int rx = curr[0];
                int cx = curr[1];

                for(int[] d : dir){
                    int nr = rx + d[0];
                    int nc = cx + d[1];

                    if( nr>=0 && nc>=0 && nr<r && nc<c && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh -- ; 
                        q.offer(new int[]{nr, nc});
                        rottenThisMin = true ; 
                    }
                }
            }
            if(rottenThisMin){min++;}
        }
        return fresh == 0 ? min : -1 ; 
    }
}