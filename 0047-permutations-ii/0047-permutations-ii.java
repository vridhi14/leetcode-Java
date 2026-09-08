class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); 
        boolean[] used = new boolean[nums.length]; 
        backtrack(nums , used , new ArrayList<>()); 
        return result ; 
    }
    public void backtrack(int[]nums , boolean[]used , List<Integer>current ){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current)); 
        }
        for(int i = 0 ; i<nums.length ; i++){

            if(used[i]){
                continue ; 
            }
            if(i > 0 && nums[i]== nums[i-1] && !used[i-1]){
                continue; 
            }

            used[i]= true ; 
            current.add(nums[i]); 

            backtrack(nums , used , current); 
            
            current.remove(current.size()-1); 
            used[i]= false ; 
        }
    }
}