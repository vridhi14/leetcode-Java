class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
          for(int row = 0 ; row<9 ; row++){
            for(int col = 0 ; col<9 ; col++){
                if(board[row][col] == '.'){
                    for(char ch = '1' ; ch<='9'; ch++){
                        if(isValid(board , row , col , ch)){
                            board[row][col] = ch ; 

                            if(solve(board))return true ; 

                            board[row][col] = '.'; 
                        }
                    }
                    return false ; 
                }
            }
        }
        return true ; 
    }
    private boolean isValid(char[][]board , int row , int col , char ch){
        //row ~ 
        for(int j = 0 ; j< 9 ; j++){
            if(board[row][j] == ch){
                return false ; 
            }
        }
        //col~
        for(int i = 0 ; i< 9 ; i++){
            if(board[i][col] == ch){
                return false ; 
            }
        }
        //3X3 box 
        int startRow = (row/3)*3; 
        int startCol = (col/3)*3; 

        for(int i = startRow ; i<startRow+3 ; i++){
            for(int j = startCol ; j<startCol+3 ; j++){
                if(board[i][j] == ch)
                return false ; 
            }
        }
        return true ; 
    }
}