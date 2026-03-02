class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length ; 
        int mod = 1_000_000_007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // LEFT: previous smaller (strictly smaller)
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        // RIGHT: next smaller OR equal (go RIGHT → LEFT)
        for(int i = n-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        long ans = 0;
        for(int i = 0 ; i < n ; i++){
            long contrib = (long) arr[i] * left[i] * right[i];
            ans = (ans + contrib) % mod;
        }

        return (int) ans;
    }
}