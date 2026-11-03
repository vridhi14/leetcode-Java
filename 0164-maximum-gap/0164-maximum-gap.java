class Solution {
    public int maximumGap(int[] nums) {

        int n = nums.length;

        if (n < 2) return 0;

        // Find minimum and maximum
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;

        // Calculate bucket size
        int bucketSize = Math.max(
            1, (max - min + n - 2) / (n - 1)
        );

        // Number of buckets
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        // Initialize buckets
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Distribute numbers into buckets
        for (int num : nums) {

            int index = (num - min) / bucketSize;

            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }

        // Find maximum gap
        int ans = 0;
        int prevMax = min;

        for (int i = 0; i < bucketCount; i++) {

            if (bucketMin[i] == Integer.MAX_VALUE) {
                continue;
            }

            ans = Math.max(ans, bucketMin[i] - prevMax);

            prevMax = bucketMax[i];
        }

        return ans;
    }
}
