class Solution {
    class DSU{
        int[] parent ; 
        int[] size ;

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
        void union(int u , int v){
            int pu = find(u);
            int pv = find(v);
            if(pu == pv) return ; 
            if(size[pu]<size[pv]){
                parent[pu] = pv ; 
                size[pv] += size[pu];
            }
            else{
                parent[pv] = pu ; 
                size[pu] += size[pv]; 
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1 ; 
        DSU dsu = new DSU(n); 
        for(int[] edge : connections){
            dsu.union(edge[0], edge[1]);
        }
        int components = 0 ; 
        for(int i = 0 ; i<n ; i++){
            if(dsu.find(i)==i){
                components++ ; 
            }
        }
        return components - 1 ; 
    }
}