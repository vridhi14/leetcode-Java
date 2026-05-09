class Solution {

    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // Step 1: Mark boundary connected O's
        for(int i = 0; i < n; i++) {

            // first column
            if(board[i][0] == 'O') {
                dfs(i, 0, board);
            }

            // last column
            if(board[i][m - 1] == 'O') {
                dfs(i, m - 1, board);
            }
        }

        for(int j = 0; j < m; j++) {

            // first row
            if(board[0][j] == 'O') {
                dfs(0, j, board);
            }

            // last row
            if(board[n - 1][j] == 'O') {
                dfs(n - 1, j, board);
            }
        }

        // Step 2: Convert surrounded O -> X
        // Step 3: Restore T -> O

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                else if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {

        int n = board.length;
        int m = board[0].length;

        // mark safe
        board[row][col] = 'T';

        for(int i = 0; i < 4; i++) {

            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < n &&
               nCol >= 0 && nCol < m &&
               board[nRow][nCol] == 'O') {

                dfs(nRow, nCol, board);
            }
        }
    }
}
