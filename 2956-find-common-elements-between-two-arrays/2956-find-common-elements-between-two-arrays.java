class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // Store nums1 elements
        for (int num : nums1) {
            set1.add(num);
        }

        // Store nums2 elements
        for (int num : nums2) {
            set2.add(num);
        }

        int count1 = 0;
        int count2 = 0;

        // Count nums1 elements present in nums2
        for (int num : nums1) {
            if (set2.contains(num)) {
                count1++;
            }
        }

        // Count nums2 elements present in nums1
        for (int num : nums2) {
            if (set1.contains(num)) {
                count2++;
            }
        }

        return new int[]{count1, count2};
    }
}