class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0 ; 

        for( char c : s.toCharArray() ){

            if( c == ')') cnt-- ; 
            
            if(cnt != 0 ) ans.append(c) ;

            if( c == '(') cnt++ ; 
        }
        return ans.toString() ;
    }
}