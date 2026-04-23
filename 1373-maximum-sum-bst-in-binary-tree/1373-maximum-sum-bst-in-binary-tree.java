class Solution {

    class NodeValue {
        int min, max, sum;
        boolean isBST;

        NodeValue(int min, int max, int sum, boolean isBST) {
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isBST = isBST;
        }
    }

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private NodeValue helper(TreeNode node) {

        // Base case
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        NodeValue left = helper(node.left);
        NodeValue right = helper(node.right);

        // ✅ Check valid BST
        if (left.isBST && right.isBST &&
            node.val > left.max && node.val < right.min) {

            int sum = left.sum + right.sum + node.val;

            maxSum = Math.max(maxSum, sum);

            int min = Math.min(node.val, left.min);
            int max = Math.max(node.val, right.max);

            return new NodeValue(min, max, sum, true);
        }

        // ❌ Not a BST → break the chain
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
    }
}