class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length ; 
        if(n == 1) return 1 ; 

        Set<Integer> pairXors = new HashSet<>(); 
        BitSet tripletXors = new BitSet(); 

        for(int i = 0 ; i<n ; i++){
            for(int j= 0 ; j< n ; j++){
                pairXors.add(nums[i] ^ nums[j]);
            }
        }
        for(int pair : pairXors){
            for(int num : nums){
                tripletXors.set(pair ^ num); 
            }
        }
        return tripletXors.cardinality(); 
     }
}