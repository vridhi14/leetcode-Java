class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp , -1); 
        return solve(0,arr,k,dp ); 
    }
    private int solve(int i , int[]arr , int k , int[] dp){
        if(i == arr.length){return 0 ;} 
        if(dp[i] != -1){
            return dp[i] ; 
        }
        
        int maxElement = 0 ; 
        int maxAnswer = 0 ; 

        for(int j = i ;  j < arr.length && j < i + k ; j++){
            maxElement = Math.max(maxElement , arr[j]);
            int length = j - i + 1 ; 
            int currentSum = maxElement * length + solve( j+1 , arr , k , dp);
            maxAnswer = Math.max(maxAnswer , currentSum);
        }
        return dp[i] = maxAnswer ; 
    }
}