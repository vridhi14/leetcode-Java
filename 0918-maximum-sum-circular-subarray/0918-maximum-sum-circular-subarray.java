class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0] ; 
        int n = nums.length ; 
        int currentMax = nums[0];
        int maxSum =  nums[0];
        int currentMin = nums[0];
        int minSum =  nums[0];

        for(int i = 1 ; i<n ; i++){
            currentMax = Math.max(nums[i] , currentMax + nums[i]); 
            maxSum = Math.max(maxSum , currentMax);

            currentMin = Math.min(nums[i] , currentMin + nums[i]); 
            minSum = Math.min(minSum , currentMin);

            total += nums[i] ; 
        }
        
        if(minSum == total) return maxSum;
        return Math.max(maxSum, total - minSum); 
    }
}