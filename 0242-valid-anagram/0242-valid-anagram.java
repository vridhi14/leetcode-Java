class Solution {
    public boolean isAnagram(String s, String t) {
        if( s.length() != t.length()) return false ; 

        int [] freq = new int[26] ; 
 // Count characters in s
        for( char c : s.toCharArray()){
            freq[c-'a'] ++ ; 
        }
 // Subtract characters using t
        for( char c : t.toCharArray()){
             freq[c - 'a']--;
            if (freq[c - 'a'] < 0) {
                return false;
            }
        }

        return true ; 
    }
}