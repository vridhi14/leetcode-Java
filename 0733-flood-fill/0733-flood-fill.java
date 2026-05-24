class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int original = image[sr][sc];
       if(original == newColor){return image ; }
       dfs(image , sr , sc , original , newColor);
       return image ; 
    }
    public void dfs(int[][]image , int r, int c , int original , int color){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length)return ; 

        if(image[r][c]!= original)return ; 

        image[r][c]= color ; 
        
        dfs(image , r+1 , c , original , color);
        dfs(image , r-1 , c , original , color);
        dfs(image , r , c+1 , original , color);
        dfs(image , r , c-1 , original , color);
    } 
}