class Solution {
    class DSU{
        int[] parent; 
        int[] size; 

        DSU(int n){
            parent = new int[n];
            size = new int[n];

            for(int i = 0 ; i<n ; i++){
                parent[i] = i ; 
                size[i] = 1 ; 
            }
        }
        int find(int node){
            if(parent[node] == node) return node ; 
            return parent[node] = find(parent[node]); 
        }
        void union(int u  ,int v){
            int pu = find(u);
            int pv = find(v); 
            if(pu == pv) return ; 
            
            if(size[pu]< size[pv]){
                parent[pu] = pv ; 
                size[pv] += size[pu];
            }
            else{
                parent[pv] = pu ; 
                size[pu] += size[pv];
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length ; 
        DSU dsu = new DSU(n); 
        for(int i =0 ; i<n ; i++){
            for(int j = i+1 ; j<n ; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    dsu.union( i , j); 
                }
            }
        }
        int components = 0 ; 
        for(int i = 0 ; i < n ; i++){
            if(dsu.find(i) == i){
                components++ ; 
            }
        }
        return n - components ; 
    }
}