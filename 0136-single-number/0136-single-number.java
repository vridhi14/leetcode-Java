class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0 ; i< nums.length ;i++){
            int cnt = 0 ; 
            int num = nums[i]; 
            for(int j = 0 ; j< nums.length ;j++){
                if(nums[j]==num){
                    cnt ++ ;
                }
            }
            if(cnt == 1){
                return nums[i] ; 
            }
        }
        return -1 ; 
    }
}