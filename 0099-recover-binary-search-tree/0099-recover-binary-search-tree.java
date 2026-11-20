/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                detect(curr);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;

                // Find inorder predecessor
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    detect(curr);
                    curr = curr.right;
                }
            }
        }

        // swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void detect(TreeNode curr) {
        if (prev != null && prev.val > curr.val) {
            if (first == null) {
                first = prev;   // first violation
            }
            second = curr;      // update second every time
        }
        prev = curr;
    }
}