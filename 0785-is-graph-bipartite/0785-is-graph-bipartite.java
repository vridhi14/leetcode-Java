class Solution {
    public boolean isBipartite(int[][] graph) {
// -1 → uncolored
// 0 → one color
// 1 → other color

int n = graph.length ; 
int[] colour = new int[n];
Arrays.fill(colour , -1);

for(int i = 0 ; i<n ; i++){
if(colour[i]== -1){
Queue<Integer> q = new LinkedList<>();
q.offer(i);
colour[i] = 0 ; 

while(!q.isEmpty()){
    int node = q.poll();
    for(int neighbour : graph[node]){
        if(colour[neighbour] == -1){
            colour[neighbour] = 1 - colour[node];
            q.offer(neighbour);
        }
        else if(colour[neighbour] == colour[node]){
            return false ; 
        }
    }
}
}
}
return true ; 
    }
}