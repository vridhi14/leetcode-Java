class Solution {
    public boolean searchMatrix(int[][] matrix, int target){
        int rows = matrix.length ;
        int cols = matrix[0].length ; 

        int low = 0 ; 
        int high = (rows*cols) - 1 ; 

        while(low <= high){
            int mid = low+ (high-low) / 2 ; 

            int r = mid / cols ; 
            int c = mid % cols ; 

            int value = matrix[r][c] ; 
            
            if(value == target) return true ; 
            else if(value < target) low = mid + 1 ; 
            else high = mid - 1 ; 
        }
        return false ; 
    }
}