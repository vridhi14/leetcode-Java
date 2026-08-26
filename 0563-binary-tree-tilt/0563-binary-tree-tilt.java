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
    int totalTilt = 0 ; 
    public int findTilt(TreeNode root) {
        calculateSum(root);
        return totalTilt ; 
    }
    private int calculateSum(TreeNode node){
        if(node == null){
            return 0 ; 
        }

        int leftSum = calculateSum(node.left);
        int rightSum = calculateSum(node.right); 

        totalTilt += Math.abs(leftSum - rightSum);

        return node.val + leftSum + rightSum ; 
    }
}