class Solution{
    public int minimumEffortPath(int[][] heights){
        int m = heights.length ; 
        int n = heights[0].length ; 
        int[][] effort = new int[m][n]; 
        for(int i = 0 ; i< m ; i++){
            Arrays.fill(effort[i] , Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq =  new PriorityQueue<>((a, b) -> a[0] - b[0]);
         pq.offer(new int[]{0, 0, 0});

        effort[0][0] = 0;

        int[][] dir = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while(!pq.isEmpty()){
            int[] curr = pq.poll(); 

            int currEffort = curr[0]; 
            int row = curr[1]; 
            int col = curr[2];

            if(row == m-1 && col == n-1) return currEffort ; 

            for(int[] d : dir){
                int nr = row + d[0]; 
                int nc = col + d[1]; 

                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int diff = Math.abs(heights[row][col] - heights[nr][nc]); 
                      int newEffort =
                            Math.max(currEffort, diff);
                               if (newEffort < effort[nr][nc]) {

                        effort[nr][nc] = newEffort;

                        pq.offer(new int[]{
                                newEffort,
                                nr,
                                nc
                        });
                    }
                }
                }
            }
            return 0 ; 
        }
    }
