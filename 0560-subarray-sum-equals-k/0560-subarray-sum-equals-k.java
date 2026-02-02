class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0; // ✅ initialize sum here for each starting point
            for (int j = i; j < n; j++) { // ✅ inner loop should start from i, not 1
                sum += nums[j]; // ✅ correct addition syntax
                if (sum == k) {
                    count++; // ✅ add semicolon
                }
            }
        }

        return count; // ✅ must return count
    }
}
