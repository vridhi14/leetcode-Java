class Solution {
    public void setZeroes(int[][] matrix) {
        //Initialising ArrayList to store indexes of zeros' location
        ArrayList<Integer> list = new ArrayList<>();
        int row, col;
        //Using Nested loops for traversing through each element  
        for (int i = 0; i < matrix.length; i++) {           //Traversing Rows
            for (int j = 0; j < matrix[i].length; j++) {    //Traversing Columns
                if (matrix[i][j] == 0) {                //If zero found
                    list.add(i);                        //Storing Row index in list
                    list.add(j);                        //Storing Column index in list
                }
            }
        }
        for (int i = 0; i < list.size(); i += 2) {      //Traversing the list we created with stored index values of zeros in matrix
            row = list.get(i);                      //Retrieving Row Index of zero
            col = list.get(i + 1);                  //Retrieving Column Index of zero
            for (int c = 0; c < matrix[row].length; c++) {
                matrix[row][c] = 0;                 //Setting Row zero for column (0 to max row length)
            }
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][col] = 0;                 //Setting Column zero for row (0 to max column depth)
            }
        }
    }
}