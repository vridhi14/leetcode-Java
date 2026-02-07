class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1,k,n, new ArrayList<>(), result);
        return result ;
    }
 private void backtrack(int start, int k, int remainingSum,
                           List<Integer> temp, List<List<Integer>> result) {

       if (temp.size() == k) {
            if (remainingSum == 0)
             result.add(new ArrayList<>(temp));
            return;
         }
        for(int num = start; num<= 9 ; num++){
            if(num > remainingSum) break;

            temp.add(num);
            backtrack(num+1 , k , remainingSum - num , temp , result);
            temp.remove(temp.size()-1);
        }
    }
}