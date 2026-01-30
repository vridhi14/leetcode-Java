class Solution {
    public int maxSubArray(int[] nums) {
        int start = 0 ; 
        int ansStart = -1 ; 
        int ansEnd = -1 ; 
        int sum = 0 ; 
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i<nums.length ; i++){
            if(sum == 0 ) start = i ; 

            sum = sum + nums[i];

            if(sum > max){
                max = sum ; 
                ansEnd = i ; 
                ansStart = start ;
            }
            if(sum < 0) sum = 0 ; 
        }
        return max ; 
    }
}