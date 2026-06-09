class Solution {
    public long maxTotalValue(int[] nums, int k) {
        //But maximum should start from the smallest possible value , otherwise it will always remain Integer.MAX_VALUE.nd same goes for min value 
        int max = Integer.MIN_VALUE ; 
        int min = Integer.MAX_VALUE ;

        for(int num : nums){
            max = Math.max(max , num);
            min = Math.min(min , num);
        }
        return 1L * k * (max-min) ;
    }
}