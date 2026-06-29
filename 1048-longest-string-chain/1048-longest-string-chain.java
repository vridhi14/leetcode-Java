class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words ,(a,b)-> a.length() - b.length()); 
        int n = words.length;
        int[] dp = new int[n]; 
        Arrays.fill(dp,1);
        int ans =1 ; 

        for(int i = 0 ; i<n ; i++){
            for(int prev = 0 ; prev< i ; prev++){
                if( isPredecessor(words[prev] , words[i])){
                    dp[i] = Math.max(dp[i] , dp[prev] + 1);
                }
            }
            ans = Math.max(ans , dp[i]);
        }
        return ans;
    }


    private boolean isPredecessor(String small , String large){
        if(large.length() != small.length() + 1 ) return false; 

        int i = 0 , j = 0 ; 
        while( i < small.length() && j<large.length()){
            if(small.charAt(i) == large.charAt(j)){
                i++;
                j++;
            }
            else{ 
                j++ ;
            }
        }
        return i == small.length();
    }
}