class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int i = left; i <= right; i++)
                ans.add(matrix[top][i]);
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++)
                ans.add(matrix[i][right]);
            right--;

            // Traverse bottom row (check if top <= bottom)
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(matrix[bottom][i]);
                bottom--;
            }

            // Traverse left column (check if left <= right)
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(matrix[i][left]);
                left++;
            }
        }

        return ans;
    }
}
