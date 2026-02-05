class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,candidates,target, new ArrayList<>(), result);
        return result ; 
    }
    private void backtrack(int index , int[] arr , int target , List<Integer> path , List<List<Integer>>result){
        if(target==0){
            result.add(new ArrayList<>(path));
            return ;
        }
        if(index==arr.length || target<0){
            return;
        }

        //chose the current element
        path.add(arr[index]);
        backtrack(index , arr , target-arr[index] , path , result);
        path.remove(path.size()-1);

        //skip the current element
         backtrack(index+1 , arr , target , path , result);
    }
}