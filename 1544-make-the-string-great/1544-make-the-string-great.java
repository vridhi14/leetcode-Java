class Solution {
    public String makeGood(String s) {
        StringBuilder st = new StringBuilder(); 
        for(char ch : s.toCharArray()){
            int n = st.length(); 

            if(n > 0 && Math.abs(st.charAt(n-1) - ch) == 32){
                st.deleteCharAt(n - 1); 
            }else{
                st.append(ch); 
            }
        }
        return st.toString(); 
    }
}