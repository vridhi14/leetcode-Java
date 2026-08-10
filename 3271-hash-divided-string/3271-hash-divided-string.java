class Solution {
    public String stringHash(String s, int k) {
        StringBuilder ans = new StringBuilder() ; 

        for(int i = 0 ; i< s.length() ; i+=k ){
            int sum = 0 ; 

            for(int j = i ; j< i+k ;j++){
                sum += s.charAt(j) - 'a';
            }
            int hash = sum % 26 ; 
            ans.append( (char)('a'+ hash) );
        }
        return ans.toString() ; 
    }
}