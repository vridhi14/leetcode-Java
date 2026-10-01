class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(String s, int start, List<String> path, List<String> result){

        if(path.size() == 4){
            if(start == s.length()){
                result.add(String.join("." , path)); 
            }
            return ; 
        }

        for (int end = start; end < Math.min(start + 3, s.length()); end++) {

            String part = s.substring(start ,end+1); 

            if(part.length() > 1 && part.charAt(0) == '0'){
                break;
            }
            if (Integer.parseInt(part) > 255) {
                break;
            }
            path.add(part); 
            backtrack(s , end +1 , path , result); 
            path.remove(path.size()-1); 
        }
    }
}