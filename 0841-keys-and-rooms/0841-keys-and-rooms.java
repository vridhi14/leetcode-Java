class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()]; 
        dfs(0 , rooms , visit); 

        for(boolean room : visit){
            if(!room){
                return false ; 
            }
        }
        return true ; 
    }
    private void dfs( int room , List<List<Integer>> rooms ,boolean[] visit){

        if (visit[room]) {
            return;
        }

        visit[room]= true ; 

        for (int key : rooms.get(room)) {
            dfs(key, rooms, visit);
        }
    }
}