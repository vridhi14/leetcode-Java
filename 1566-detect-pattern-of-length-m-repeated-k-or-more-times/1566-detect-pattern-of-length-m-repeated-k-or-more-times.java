
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;

        for (int i = 0; i + m * k <= n; i++) {
            int count = 0;

            for (int j = i; j < i + m * k - m; j++) {
                if (arr[j] == arr[j + m]) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == m * k - m) {
                return true;
            }
        }

        return false;
    }
}
