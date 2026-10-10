class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26]; 
        boolean[] seen = new boolean[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++ ; 
        }

        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){           
            freq[ch - 'a']-- ; 
            if(seen[ch-'a']) continue ; 

            while(!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] > 0){
                seen[st.pop() - 'a'] = false ; 
            }

            st.push(ch); 
            seen[ch-'a'] = true ; 
        }

        StringBuilder ans = new StringBuilder();
        for (char c : st) {
            ans.append(c);
        }
        return ans.toString();
    }
}