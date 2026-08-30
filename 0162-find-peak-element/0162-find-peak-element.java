class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid is less than next element → peak is on the right
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } 
            // Else → peak is on the left side (or mid itself)
            else {
                high = mid;
            }
        }

        return low; // low == high = peak index
    }
}
