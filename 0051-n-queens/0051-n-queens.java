class Solution {

    List<List<String>> ans = new ArrayList<>(); 
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n]; 
        for(char[] row : board){
            Arrays.fill(row , '.');
        } 

            boolean[] col = new boolean[n];
            boolean[] diag = new boolean[2*n];
            boolean[] antiDiag = new boolean[2*n];

            backtrack(0 , board , col , diag ,antiDiag , n);
            return ans ; 
        }

        private void backtrack(int row ,char[][]board , boolean[]col , boolean[]diag , boolean[]antiDiag, int n){
            if(row == n){
                List<String> temp = new ArrayList<>(); 
                for(char[] r:board){
                    temp.add(new String(r));
                   
                }
                 ans.add(temp);
                 return ; 
                }

                for(int c = 0 ; c<n ; c++){
                    int d = row-c+n ; 
                    int ad = row+c ; 

                    if(col[c] || diag[d] ||antiDiag[ad]){
                        continue ; 
                    }

                    board[row][c] = 'Q';
                    col[c]= true ; 
                    diag[d]= true ; 
                    antiDiag[ad]= true ; 

                    backtrack(row+1 , board, col , diag , antiDiag ,n ); 

                    board[row][c] = '.'; 
                    col[c]= false ; 
                    diag[d]= false ; 
                    antiDiag[ad]= false ; 
                }
            }
        }
    