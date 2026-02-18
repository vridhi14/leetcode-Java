class Solution {

    public int splitArray(int[] nums, int m) {
        int low = getMax(nums);
        int high = getSum(nums);
        
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, m, mid)) {
                high = mid;       // try smaller largest sum
            } else {
                low = mid + 1;    // need bigger limit
            }
        }
        return low;
    }

    private boolean canSplit(int[] nums, int m, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                subarrays++;
                currentSum = num;
                if (subarrays > m) return false;
            }
        }
        return true;
    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) max = Math.max(max, num);
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }
}
