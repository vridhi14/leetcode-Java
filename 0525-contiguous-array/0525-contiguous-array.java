class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 exists before the array starts
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            // 0 -> -1
            // 1 -> +1
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            // Same sum seen before?
            if (map.containsKey(sum)) {

                int prevIndex = map.get(sum);

                maxLen = Math.max(maxLen, i - prevIndex);

            } else {

                // Store ONLY the first occurrence
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}