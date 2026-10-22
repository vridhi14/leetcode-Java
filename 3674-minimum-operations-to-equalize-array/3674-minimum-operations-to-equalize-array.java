class Solution {
    public int minOperations(int[] nums) {
        for(int num : nums){
            if(num != nums[0]){
                return 1 ; 
            }
        }
        return 0 ; 
    }
}