class Solution {
    public int findMin(int[] nums) {
        int n = nums.length ; 
        int low = 0 ; 
        int high = n-1 ; 
        int ans = Integer.MAX_VALUE ; 

        while(low<=high){

            // if subarray already sorted
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }

            int mid = (low+high)/2 ;

// left part sorted !! 
            if(nums[low]<=nums[mid]){
                ans = Math.min(ans , nums[low]);
                low = mid + 1 ;
            }
            else { 
                ans = Math.min(ans , nums[mid]); 
                high = mid -1 ; 
            }
        }
        return ans ; 

        
    }
}