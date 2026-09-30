class Solution {
    public List<Integer> grayCode(int n) {
        int size = 1 << n ; //2 power n ! 
        List<Integer> ans = new ArrayList<>(); 

        for(int i=0 ; i< size; i++){
            ans.add( i ^ ( i >> 1 )); 
        }

        return ans ; 
    }
}