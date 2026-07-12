class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character>st = new Stack<>(); 
        for(char ch : expression.toCharArray()){
            if(ch == ','){
                continue;
            }
            if(ch != ')'){
                st.push(ch); 
            }else{
                int t = 0 , f = 0  ; 
                 
                while(st.peek()!= '('){
                    char curr = st.pop();
                    if(curr == 't') t++ ; 
                    else f++; 
                }

                st.pop();
                char op = st.pop();
                //not
                if(op == '!'){
                    st.push( f== 1 ? 't' : 'f');
                }//and
                else if(op == '&'){
                    st.push(f > 0 ? 'f' : 't');
                }//or
                else { 
                    st.push( t>0 ? 't' : 'f');
                }
            }
        }
        return st.peek() =='t'; 
    }
}