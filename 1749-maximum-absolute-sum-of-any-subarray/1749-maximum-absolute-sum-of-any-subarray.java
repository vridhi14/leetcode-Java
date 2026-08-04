class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnding = 0 , minEnding = 0 ; 
        int maxSum = 0 ,minSum = 0 ; 

        for(int i = 0; i<nums.length ; i++){
            maxEnding = Math.max(nums[i] , maxEnding + nums[i]); 
            maxSum = Math.max(maxSum , maxEnding); 
            minEnding = Math.min(nums[i] , minEnding + nums[i]); 
            minSum = Math.min(minSum , minEnding); 
        }
        return Math.max(maxSum, -minSum);
    }
}