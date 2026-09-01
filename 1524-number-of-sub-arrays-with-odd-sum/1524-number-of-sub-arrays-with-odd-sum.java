class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;

        int even = 1 ; 
        int odd = 0 ; 
        int sum = 0 ; 
        int ans = 0 ; 

        for(int num : arr){
            sum += num ; 

            if(sum % 2 == 1 ){
                ans = (ans + even ) % MOD ;  
                odd++; 
            }else {
                ans = (ans + odd) % MOD;
                even++;
            }
        }
        return ans ; 
    }
}