class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + rev;
        int[] lps = buildLPS(temp);
        int palindromeLength = lps[lps.length - 1];
       String toAdd = rev.substring(0, s.length() - palindromeLength);
       return toAdd + s;
    }
     private int[] buildLPS(String str) {
        int[] lps = new int[str.length()];
        int j = 0;

        for (int i = 1; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = lps[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        return lps;
    }
}