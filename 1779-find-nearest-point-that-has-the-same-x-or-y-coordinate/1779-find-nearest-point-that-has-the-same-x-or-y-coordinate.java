class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE ; 
        int answer = -1 ; 
        
        for(int i = 0 ; i<points.length ; i++){
            int xi = points[i][0];
            int yi = points[i][1];

            if(xi == x || yi == y){
                int distance = Math.abs(xi-x) + Math.abs(yi-y); 

                if(minDistance > distance){
                    minDistance = distance ; 
                    answer = i ; 
                }
            }
        }
        return answer ; 
    }
}