class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            // 1. Opening brackets → push
            if(c == '('||c == '['||c == '{'){
                st.push(c);
            }
            else{
                 // 2. Closing bracket but stack empty → invalid
                if(st.isEmpty()) return false ;
                char top = st.pop();
                // // 3. Check mismatch
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }

        }
         // 4. Stack must be empty at end
          return st.isEmpty();
    }
}