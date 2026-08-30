class Solution {
    public int minimumOperations(List<Integer> nums) {
        int dp1 = 0 ; 
        int dp2 = 0 ; 
        int dp3 = 0 ; 

        for(int num : nums){

            if(num == 1){
                dp1++ ; 
            }
            else if(num == 2){
                dp2 = Math.max(dp1,dp2)+1 ; 
            }
            else{
                dp3 = Math.max(dp1 , Math.max(dp2,dp3))+1 ; 
            }
        }
        int longest = Math.max(dp1, Math.max(dp2, dp3)); 
        return nums.size() - longest ; 
    }
}