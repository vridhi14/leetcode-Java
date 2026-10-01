class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>result = new ArrayList<>(); 
        backtrack(s , 0 , new ArrayList<>() , result); 
        return result ; 
    }
    private void backtrack(String s , int start , List<String> path, List<List<String>> result ){

        // We reached the end of the string
        if(start == s.length()){
            result.add(new ArrayList<>(path)); 
            return; 
        }

        //try every possible ending ! 
        for(int end = start ; end < s.length(); end++){
            if(isPallindrone(s, start ,end)){
                String part = s.substring(start , end+1); 
                path.add(part); 
                backtrack(s , end+1 , path , result); 
                path.remove(path.size()-1); 
            }
        }
    }
    private boolean isPallindrone(String s , int left , int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false ; 
            }
            left++ ; 
            right-- ; 
        }
        return true;
    }
}