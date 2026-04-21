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
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {
        // Base case
        if (i == preorder.length || preorder[i] > bound) {
            return null;
        }

        // Create root
        TreeNode root = new TreeNode(preorder[i++]);

        // Build left subtree (values < root.val)
        root.left = build(preorder, root.val);

        // Build right subtree (values < bound but > root.val)
        root.right = build(preorder, bound);

        return root;
    }
}