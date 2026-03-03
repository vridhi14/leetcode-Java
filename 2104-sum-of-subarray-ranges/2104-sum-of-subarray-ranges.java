class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long[] maxLeft = new long[n]; 
        long[] maxRight = new long[n];
        long[] minLeft = new long[n]; 
        long[] minRight = new long[n];

        // ---- For MAX ----
        Stack<Integer> st = new Stack<>();

        // Previous Greater Element (strict)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            maxLeft[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater Element (non-strict)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            maxRight[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        // ---- For MIN ----
        st.clear();

        // Previous Smaller Element (strict)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            minLeft[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller Element (non-strict)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            minRight[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        // Sum contributions
        long maxSum = 0, minSum = 0;

        for (int i = 0; i < n; i++) {
            maxSum += nums[i] * maxLeft[i] * maxRight[i];
            minSum += nums[i] * minLeft[i] * minRight[i];
        }

        return maxSum - minSum;
    }
}