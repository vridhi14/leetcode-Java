class Solution {
    public void setZeroes(int[][] matrix) {
       ArrayList<Integer> list = new ArrayList<>();
       int row ; 
       int col ; 
       for(int i = 0 ;i <matrix.length ; i ++){
        for(int j = 0 ; j <matrix[i].length ; j++){
            if(matrix[i][j] == 0 ){
                list.add(i);
                list.add(j);
            }
        }
       }

       for( int i = 0 ; i< list.size() ; i+=2){
        row = list.get(i);
        col = list.get(i+1);

        for(int c = 0 ; c < matrix[row].length ; c++){
            matrix[row][c] = 0 ; 
        }
        for(int r = 0 ; r < matrix.length ; r++){
            matrix[r][col] = 0 ; 
        }
       }
    }
}