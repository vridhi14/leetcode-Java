class Solution {
    public int minChanges(int n, int k) {

        // If k has a 1 where n has a 0,
        // we cannot make n equal to k.
        if ((n & k) != k) {
            return -1;
        }

        // Count the bits that need to change from 1 -> 0
        return Integer.bitCount(n ^ k);
    }
}