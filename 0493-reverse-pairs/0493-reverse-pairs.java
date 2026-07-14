class Solution {
    int count = 0 ; 
    public int reversePairs(int[] nums) {
        mergeSort(nums , 0 , nums.length - 1 ); 
        return count ; 
    }
    private void mergeSort(int[]nums, int left , int right){
        if(left>=right) return ; 
        int mid = left+(right-left)/2 ; 

        mergeSort(nums , left , mid);
        mergeSort(nums , mid+1 , right); 

        countPairs(nums, left , mid , right); 
        merge(nums , left , mid , right);
    }
    private void countPairs(int[]nums , int left ,int mid , int right){
        int j = mid+1 ; 

        for(int i = left ; i<=mid ; i++){
            while(j<= right && nums[i] > 2L * nums[j]){
                j++ ; 
            }
            count += j - (mid+1); 
        }
    }
    private void merge(int[]nums , int left , int mid , int right){

        ArrayList<Integer> temp = new ArrayList<>(); 
        int i = left ; 
        int j = mid+1 ; 

        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                temp.add(nums[i++]);
            }else{
                temp.add(nums[j++]);
            }
        }
        while( i<= mid){
            temp.add(nums[i++]);
        }
        while( j<= right){
            temp.add(nums[j++]);
        }
        for(int k = left ; k<= right ; k++){
            nums[k] = temp.get(k-left); 
        }
    }
}