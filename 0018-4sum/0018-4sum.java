class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: First element
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Second element
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Step 4: Two pointers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i]
                             + nums[j]
                             + nums[left]
                             + nums[right];

                    // Found quadruplet
                    if (sum == target) {

                        result.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));

                        left++;
                        right--;

                        // Skip duplicate left values
                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate right values
                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }

                    // Sum is too small
                    else if (sum < target) {
                        left++;
                    }

                    // Sum is too large
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}