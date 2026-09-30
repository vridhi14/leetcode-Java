class Solution {
    int count = 0 ; 
    public int totalNQueens(int n) {
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> diag1 = new HashSet<>();
        HashSet<Integer> diag2 = new HashSet<>();
        backtrack(0 , n , cols , diag1 , diag2); 
        return count ; 
    }
    void backtrack(int row , int n  , HashSet<Integer> cols, HashSet<Integer> diag1 , HashSet<Integer> diag2){
        if(row == n){
            count++; 
            return ; 
        }

        for(int c = 0 ; c<n ; c++){

            if(cols.contains(c) || diag1.contains(row-c) || diag2.contains(row+c)){
                continue;
            }

            //plave 
            cols.add(c); 
            diag1.add(row-c);
            diag2.add(row+c);

            backtrack(row+1 , n , cols , diag1 , diag2); 

            cols.remove(c);
            diag1.remove(row - c);
            diag2.remove(row + c);
        }
    }
}