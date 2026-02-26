class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        // Build next greater map for nums2
        for (int num : nums2) {
            while (!st.isEmpty() && num > st.peek()) {
                map.put(st.pop(), num);  // num is next greater
            }
            st.push(num);
        }

        // Elements left in stack have no next greater
        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        // Build result for nums1
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}