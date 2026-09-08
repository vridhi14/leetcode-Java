class Solution {

    List<String> result = new ArrayList<>();
    String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0){
            return result ; 
        }
        backtrack(digits , 0 , new StringBuilder()); 
        return result; 
    }
    private void backtrack(String digits , int index , StringBuilder sb){
        if(index == digits.length()){
            result.add(sb.toString()); 
            return ; 
        }
        String letters = map[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
        sb.append(ch); 
        backtrack(digits, index+1 , sb); 
        sb.deleteCharAt(sb.length()-1);
        } 
    }
}