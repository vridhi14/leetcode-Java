class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][]distance = new int[n][n];
        for(int i = 0 ; i<n ; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0 ; 
        }
        for(int[]edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            int dist = edge[2];
            distance[node1][node2]= dist;
            distance[node2][node1]= dist;
        }

        for(int middle=0;middle<n;middle++){
            for(int source=0;source<n;source++){
                for(int destination = 0 ; destination<n;destination++){
                    if(distance[source][middle]<Integer.MAX_VALUE && distance[middle][destination]<Integer.MAX_VALUE){
                        distance[source][destination]=Math.min( distance[source][destination] , distance[source][middle]+distance[middle][destination] ); 
                    }
                }
            }
        }
            int minNum = n ; 
            int res = -1; 

            for(int s = 0 ; s <n; s++){
                int sourceCount = 0 ; 
                for(int destination = 0 ; destination<n ; destination++){
                    if(distance[s][destination]<= distanceThreshold){
                        sourceCount++ ; 
                    }
                }
                if(sourceCount <= minNum){
                minNum= sourceCount ; 
                res = s ; 
            }
        }
            
            return res ; 
        
    }
}