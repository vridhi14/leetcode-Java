class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        int n = nums.length ; 
        for(int i = 1 ; i<n ; i++){
            int val = nums[i];
            if(val < 0){
                int temp = max ; 
                max = min ; 
                min = temp ;
            }

            max = Math.max(val , max * val);
            min = Math.min(val , min * val);

            ans = Math.max(ans,max);
        }
        return ans ; 
    }
}