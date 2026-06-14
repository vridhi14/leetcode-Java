class Solution{ 
    class DSU{
        int[] parent ; 
        int[] size ; 
        DSU(int n){
            parent = new int[n]; 
            size = new int[n]; 

            for(int i = 0 ;i<n ; i++){
                parent[i] = i ; 
                size[i] = 1 ; 
            }
        }

        int find(int node){
            if(parent[node]==node) return node ; 
            return parent[node] = find(parent[node]);
        }
        void union(int u , int v){
            int pv = find(v) ; 
            int pu = find(u) ; 
            if(pv == pu) return ; 

            if(size[pu]<size[pv]){
                parent[pu]=pv ; 
                size[pv]+= size[pu]; 
            }
            else{
                parent[pv]=pu ; 
                size[pu]+= size[pv]; 
            }
        }
    }
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}}; 
    public int largestIsland(int[][] grid) {
        
        int n = grid.length ; 
        DSU dsu = new DSU(n*n); 

        //union of all grid[i][j] == 1 ; 
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j] == 1){
                    for(int[] d:dirs){
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if(ni>=0 && nj>=0 && ni<n && nj<n && grid[ni][nj] == 1){
                            int node1 = i*n+j ; 
                            int node2 = ni*n+nj;
                            dsu.union(node1 , node2); 
                        }
                    }
                }
            }
        }
        int ans = 0 ; 

        //Try flipping every 0
        for(int i = 0 ; i <n ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer>set = new HashSet<>();
                    int currSize = 1 ; 

                    for(int[] d : dirs){
                        int ni = i+d[0]; 
                        int nj = j+d[1]; 


                        if(ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] == 1){
                            int parent = dsu.find(ni*n+nj); 
                            if(set.add(parent)){
                                currSize += dsu.size[parent]; 
                            }
                        }
                    }
                    ans = Math.max(ans , currSize); 
                }
            }
        }
        // all cells are already 1 
        for(int i = 0; i < n * n; i++) {
            ans = Math.max(ans,
                           dsu.size[dsu.find(i)]);
        }

        return ans;
    }
}