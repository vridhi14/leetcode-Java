class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0 , j = 0 ; 
        int x = 0 , y  = 0 ;

        while(i < word1.length && j < word2.length ){

            if(word1[i].charAt(x) != word2[j].charAt(y) ){
                return false ; 
            }
            x++ ; 
            y++; 

            if(x == word1[i].length()){
                i++; 
                x = 0 ; 
            }
            if(y == word2[j].length()){
                j++; 
                y = 0 ; 
            }
        }
         return i == word1.length && j == word2.length;
    }
}