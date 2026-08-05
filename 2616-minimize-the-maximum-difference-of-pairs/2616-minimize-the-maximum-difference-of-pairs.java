class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakePairs(nums, p, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canMakePairs(int[] nums, int p, int limit) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= limit) {
                count++;
                i++; // Skip both numbers since they are used
            }
        }

        return count >= p;
    }
}