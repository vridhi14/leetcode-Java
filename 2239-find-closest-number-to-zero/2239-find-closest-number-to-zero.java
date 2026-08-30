class Solution {
    public int findClosestNumber(int[] nums) {
        int ans =nums[0]; 
        for(int num : nums){
            if(Math.abs(num) < Math.abs(ans)){
                ans = num ; 
            }
            else if(Math.abs(num) == Math.abs(ans) && num > ans){
                ans = num ; 
            }
        }
        return ans ; 
    }
}