class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        // Step 1: Palindrome table
        boolean[][] isPalindrome = new boolean[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || isPalindrome[i + 1][j - 1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        // Step 2: DP for minimum cuts
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0; // no cut needed
            } else {
                int minCuts = Integer.MAX_VALUE;
                
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        minCuts = Math.min(minCuts, dp[j] + 1);
                    }
                }
                
                dp[i] = minCuts;
            }
        }

        return dp[n - 1];
    }
}