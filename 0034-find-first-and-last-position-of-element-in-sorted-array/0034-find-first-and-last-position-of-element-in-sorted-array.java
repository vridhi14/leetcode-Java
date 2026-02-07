class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums,target);
        int last = findLast(nums,target);
        return new int[]{first,last};
    }
    private int findFirst(int[]nums , int target){
        int low = 0 ; 
        int high = nums.length -1 ;
        int first = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
               first = mid ;
               high = mid -1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return first ;
    }
    private int findLast(int[]nums , int target){
        int low = 0;
        int high = nums.length - 1;
        int last = -1;

        while(low<=high){
           int mid = (low+high)/2;

            if(nums[mid]==target){
                last = mid;
                low = mid+1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else {
                high = mid - 1;
            }
        }
        return last ; 
    }
}