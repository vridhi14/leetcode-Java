class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length; 
        int [] x = new int [n]; 
        int positive = 0 ; 
        int negative = 1 ; 
        for(int num : nums ){
            if(num > 0){
                x[positive] = num ; 
                positive = positive + 2 ; 
            }
            else {
                x[negative] = num ; 
                negative = negative + 2 ; 
            }
        }
        return x ; 
    }
}