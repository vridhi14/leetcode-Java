class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Using division instead of (mid * mid <= x) to prevent integer overflow
            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1; // Try to find a larger matching integer
            } else {
                right = mid - 1; // mid is too large
            }
        }

        return ans;
    }
}
